package com.weatherforecast.application.domain;

public class CityDetail {

	private String id;
	private String name;
	private String country;
	private String population;
	private String timezone;
	private String sunrise;
	private String sunset;
	private CoordinateDetail coord;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public CoordinateDetail getCoord() {
		return coord;
	}
	public void setCoord(CoordinateDetail coord) {
		this.coord = coord;
	}
	
}
