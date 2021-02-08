package com.weatherforecast.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.weatherforecast"})
@SpringBootApplication
public class WeatherForecastDemo {

	public static void main(String ar[]) {
		SpringApplication.run(WeatherForecastDemo.class, ar);
	}
}
