package chapter02.v1;

public class Test {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);

		weatherData.setMeasurements(80, 80, 80);
		System.out.println("");
		weatherData.setMeasurements(90, 90, 90);
	}
}
