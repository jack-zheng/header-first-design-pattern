package chapter01.duckv03;

public class Test {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        mallardDuck.setFlyBehavior(new FlyRocketPowered());
        mallardDuck.performFly();
    }
}
