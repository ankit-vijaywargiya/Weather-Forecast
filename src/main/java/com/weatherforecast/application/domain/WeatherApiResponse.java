package com.weatherforecast.application.domain;

import java.util.ArrayList;
import java.util.List;

public class WeatherApiResponse {

	private String cod;
	private String message;
	private int cnt;
	private List<WeatherAttributes> list = new ArrayList<>();
	private CityDetail city;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getCnt() { 
		return cnt; 
	} 
	
	public void setCnt(int cnt) { 
		this.cnt = cnt; 
	}
	 
	public List<WeatherAttributes> getList() {
		return list;
	}
	public void setList(List<WeatherAttributes> list) {
		this.list = list;
	}
	public CityDetail getCity() {
		return city;
	}
	public void setCity(CityDetail city) {
		this.city = city;
	}
}
