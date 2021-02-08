package com.weatherforecast.application.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weatherforecast.application.domain.WeatherApiResponse;
import com.weatherforecast.application.domain.WeatherAttributes;
import com.weatherforecast.application.domain.WeatherData;
import com.weatherforecast.application.rest.RestHelper;

@Component
public class WeatherForecastService {
	
	private static final String RAIN = "rain";
	private static final Double TEMP = 40.0;
	private static final String rainWarning = "Carry Umbrella";
	private static final String heatWarning = "Use Sunscreen Lotion";

	@Autowired
	private RestHelper helper;
	
	public List<WeatherData> getWeatherForecast(String city) throws ParseException {
		List<WeatherData> weatherData = new ArrayList<>();
		WeatherApiResponse weatherApiResponse = helper.getWeatherData(city);
		Map<String,List<WeatherAttributes>> dateMap = new HashMap<>();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	    Date currentDate = getCurrentDate(sdformat);
		prepareDateMap(weatherApiResponse, dateMap, sdformat, currentDate);
		for(Map.Entry<String, List<WeatherAttributes>> entry : dateMap.entrySet()) {
			List<WeatherAttributes> attribs =  dateMap.get(entry.getKey());
			boolean isRainPredicted = false;
			boolean isHeatingPredicted = false;
			double minTempCelsius = getMinTemp(attribs);
			double maxTempCelsius = getMaxTemp(attribs);
			isRainPredicted = getRainInformation(attribs, isRainPredicted);
			if(maxTempCelsius>TEMP) {
				isHeatingPredicted = true;
			}
			String caution = getCaution(isRainPredicted, isHeatingPredicted);
			WeatherData wData = populateWeatherData(city, entry, minTempCelsius, maxTempCelsius, caution);
			weatherData.add(wData);
		}
		return weatherData;
	}

	private WeatherData populateWeatherData(String city, Map.Entry<String, List<WeatherAttributes>> entry,
			double minTempCelsius, double maxTempCelsius, String caution) {
		String minTemp = String.valueOf(minTempCelsius)+" C";
		String maxTemp = String.valueOf(maxTempCelsius)+" C";
		WeatherData wData = new WeatherData(city, maxTemp, minTemp, caution, entry.getKey());
		return wData;
	}

	private Date getCurrentDate(SimpleDateFormat sdformat) throws ParseException {
		Date currentDate = sdformat.parse(sdformat.format(new Date(System.currentTimeMillis())));
		return currentDate;
	}

	private String getCaution(boolean isRainPredicted, boolean isHeatingPredicted) {
		String caution = "";
		if(isRainPredicted) {
			caution = rainWarning;
		}else if(isHeatingPredicted) {
			caution = heatWarning;
		}
		return caution;
	}

	private boolean getRainInformation(List<WeatherAttributes> attribs, boolean isRainPredicted) {
		List<String> weatherDetail = attribs.stream().map(attr->attr.getWeather().get(0).getMain()).collect(Collectors.toList());
		for(String weather : weatherDetail) {
			if(weather.equalsIgnoreCase(RAIN)) {
				isRainPredicted = true;
				break;
			}
		}
		return isRainPredicted;
	}

	private double getMaxTemp(List<WeatherAttributes> attribs) {
		double maxTemp = 0.0;
		List<String> maxTempList = attribs.stream().map(attr->attr.getMain().getTemp_max()).collect(Collectors.toList());
		maxTemp = maxTempList.stream().mapToDouble((x)->Double.parseDouble(x)).summaryStatistics().getMax();
		return maxTemp;
	}

	private double getMinTemp(List<WeatherAttributes> attribs) {
		double minTemp = 0.0;
		List<String> minTempList = attribs.stream().map(attr->attr.getMain().getTemp_min()).collect(Collectors.toList());
		minTemp = minTempList.stream().mapToDouble(x->Double.parseDouble(x)).summaryStatistics().getMin();
		return minTemp;
	}

	private void prepareDateMap(WeatherApiResponse weatherApiResponse, Map<String, List<WeatherAttributes>> dateMap,
			SimpleDateFormat sdformat, Date currentDate) throws ParseException {
		for(WeatherAttributes attributes : weatherApiResponse.getList()) {
			String date = attributes.getDt_txt().split("\\s+")[0];
			Date recordDate = sdformat.parse(date);
			long diffInMillies = Math.abs(recordDate.getTime() - currentDate.getTime());
		    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			if(diff>0 && diff<=3) {
				if(dateMap.containsKey(date)) {
					dateMap.get(date).add(attributes);
				}else {
					List<WeatherAttributes> attrib = new ArrayList<>();
					attrib.add(attributes);
					dateMap.put(date, attrib);
				}
			}		
		}
	}
}
