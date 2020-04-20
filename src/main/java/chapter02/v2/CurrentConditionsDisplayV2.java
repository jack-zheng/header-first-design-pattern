package chapter02.v2;

import chapter02.DisplayElement;
import chapter02.v1.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplayV2 implements Observer, DisplayElement {
	Observable observable;
	private float temp;
	private float humidity;

	public CurrentConditionsDisplayV2(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: {" +
						"temp=" + temp +
						", humidity=" + humidity +
						'}');
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherDataV2) {
			WeatherDataV2 weatherDataV2 = (WeatherDataV2) o;
			this.temp = weatherDataV2.getTemp();
			this.humidity = weatherDataV2.getHumidity();
			display();
		}
	}
}
