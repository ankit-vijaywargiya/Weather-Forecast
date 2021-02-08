package com.weatherforecast.application.exception;

public class WeatherForecastException extends RuntimeException {

	public WeatherForecastException(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
