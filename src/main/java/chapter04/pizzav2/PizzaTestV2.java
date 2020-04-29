package chapter04.pizzav2;

public class PizzaTestV2 {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYStylePizzaStore();
		PizzaStore chicagoStore = new ChicagoStylePizzaStore();

		nyStore.orderPizza("Cheese");
		chicagoStore.orderPizza("Cheese");
	}
}
