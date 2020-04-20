package chapter02.v1;

import chapter02.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temp;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: {" +
						"temp=" + temp +
						", humidity=" + humidity +
						'}');
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		display();
	}
}
