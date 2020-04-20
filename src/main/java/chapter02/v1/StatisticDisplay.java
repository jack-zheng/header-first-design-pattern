package chapter02.v1;

import chapter02.DisplayElement;

public class StatisticDisplay implements Observer, DisplayElement {
	private float temp;
	private float humidity;
	private Subject weatherData;

	public StatisticDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println(String.format("Temp: %s, Humi: %s", temp, humidity));
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		display();
	}
}
