package atelier2.dp.Observer_Decorator;



public interface IObservable {
	
	public void addObserver(IOrderObserver observer);

	public void notifyObservers(String message);
	
}
