package com.weatherforecast.application.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weatherforecast.application.domain.WeatherApiResponse;
import com.weatherforecast.application.exception.WeatherForecastException;

@Component
public class RestHelper {

	@Value("${rest-url}")
	private String restUrl;
	
	@Value("${app-id}")
	private String appId;
	
	@Value("${count}")
	private String count;
	
	@Value("${units}")
	private String units;
	
	public WeatherApiResponse getWeatherData(String city) {
		WeatherApiResponse response;
		RestTemplate template = new RestTemplate();
		String url = getUrl(city);
		ResponseEntity<WeatherApiResponse> responseEntity = template.getForEntity(url, WeatherApiResponse.class);
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			response = responseEntity.getBody();
			return response;
		}else {
		   throw new WeatherForecastException("Weather API not responding!");	
		}
	}

	private String getUrl(String city) {
		String url = restUrl + "?q=" + city + "&appId=" + appId + "&cnt=" + count + "&units=" + units;
		return url;
	}
	
}
