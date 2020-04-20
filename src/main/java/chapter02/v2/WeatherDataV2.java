package chapter02.v2;

import java.util.Observable;

public class WeatherDataV2 extends Observable {
	private float temp;
	private float humidity;
	private float pressure;

	public void measurementsChagned() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChagned();
	}

	public float getTemp() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
}
