package com.weatherforecast.application.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weatherforecast.application.domain.WeatherData;
import com.weatherforecast.application.service.WeatherForecastService;

@RestController
public class WeatherForecastController {

	@Autowired
	private WeatherForecastService weatherForecastService;
	
	@CrossOrigin
	@GetMapping(value = "/weather/{city}")
	public ResponseEntity<List<WeatherData>> getWeatherData(@PathVariable String city){
		List<WeatherData> weatherData = new ArrayList<>();
		if(city!=null && !city.equalsIgnoreCase("")) {
			try {
				weatherData = weatherForecastService.getWeatherForecast(city);
			} catch (ParseException e) {
				return new ResponseEntity<List<WeatherData>>(HttpStatus.NOT_FOUND);
			} 
		}else {
			return new ResponseEntity<List<WeatherData>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<WeatherData>>(weatherData, HttpStatus.OK);
	}
}
