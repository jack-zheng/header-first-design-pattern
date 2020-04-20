package chapter02.v2;

public class Test {
	public static void main(String[] args) {
		WeatherDataV2 weatherDataV2 = new WeatherDataV2();

		CurrentConditionsDisplayV2 currentConditionsDisplayV2 = new CurrentConditionsDisplayV2(weatherDataV2);
		StatisticDisplayV2 statisticDisplayV2 = new StatisticDisplayV2(weatherDataV2);

		weatherDataV2.setMeasurements(80, 80, 80);
		System.out.println("");
		weatherDataV2.setMeasurements(90, 90, 90);
	}
}
