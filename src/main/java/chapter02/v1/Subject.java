package chapter02.v1;

public interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObserver();
}
