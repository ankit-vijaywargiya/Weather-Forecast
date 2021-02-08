package com.weatherforecast.application.domain;

import java.util.ArrayList;
import java.util.List;

public class WeatherAttributes {

	private String dt;
	private String dt_txt;
	private TemperatureDetail main;
	private List<ClimateDetail> weather = new ArrayList<>();
	private CloudDetail clouds;
	private WindDetail wind;
	private SystemDetail sys;
	private String visibility;
	private String pop;
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	public TemperatureDetail getMain() {
		return main;
	}
	public void setMain(TemperatureDetail main) {
		this.main = main;
	}
	public List<ClimateDetail> getWeather() {
		return weather;
	}
	public void setWeather(List<ClimateDetail> weather) {
		this.weather = weather;
	}
	public CloudDetail getClouds() {
		return clouds;
	}
	public void setClouds(CloudDetail clouds) {
		this.clouds = clouds;
	}
	public WindDetail getWind() {
		return wind;
	}
	public void setWind(WindDetail wind) {
		this.wind = wind;
	}
	public SystemDetail getSys() {
		return sys;
	}
	public void setSys(SystemDetail sys) {
		this.sys = sys;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	
}
