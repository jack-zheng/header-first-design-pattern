package chapter02.v1;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private List<Observer> observers;
	private float temp;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i>=0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(temp, humidity, pressure);
		}
	}

	public void measurementsChanged() {
		notifyObserver();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
