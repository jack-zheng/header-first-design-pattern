package chapter01.duckv01;

public abstract class Duck {
    public void quack() {
        System.out.println("quack");
    }

    public void swim() {
        System.out.println("swim");
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName());
    }
}
