package com.weatherforecast.application.domain;

public class WeatherData {

	private String city;
	private String highTemp;
	private String lowTemp;
	private String caution;
	private String date;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(String highTemp) {
		this.highTemp = highTemp;
	}
	public String getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(String lowTemp) {
		this.lowTemp = lowTemp;
	}
	public String getCaution() {
		return caution;
	}
	public void setCaution(String caution) {
		this.caution = caution;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public WeatherData(String city, String highTemp, String lowTemp, String caution, String date) {
		super();
		this.city = city;
		this.highTemp = highTemp;
		this.lowTemp = lowTemp;
		this.caution = caution;
		this.date = date;
	}
}
