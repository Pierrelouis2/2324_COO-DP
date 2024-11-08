package atelier2.dp.Observer_Decorator;

import java.util.LinkedList;
import java.util.List;

import atelier2.dp.Adapter.IOrderProduct;
import atelier2.dp.Strategy_TemplateMethod.IPayStrategy;
import atelier2.model.IOrder;

public class ObservableOrder implements IOrder, IObservable{

	private List<IOrderObserver> observers = new LinkedList<IOrderObserver>();
	private IOrder order;

	public ObservableOrder(IOrder order) {
		super();
		this.order = order;
	}

	public void addObserver(IOrderObserver observer) {
		observers.add(observer);
	}

	public void notifyObservers(String message) {
		for (IOrderObserver observer : observers) {
			observer.update(message);
		}
	}

	@Override
	public void addProduct(IOrderProduct product, int qty) {
		this.order.addProduct(product, qty);
		this.notifyObservers("Add " + qty + " " + product.getName() + " " + product.getPrice());
	}

	@Override
	public void removeProduct(IOrderProduct product, int qty) {
		this.order.removeProduct(product, qty);
		this.notifyObservers("Remove " + qty + " " + product.getName() + " " + product.getPrice());
	}

	@Override
	public boolean processOrder(IPayStrategy payStrategy) {
		boolean res = false;
		String message ="";

		res = this.order.processOrder(payStrategy);

		if (res) {
			message += "\n" + payStrategy + " has been successful"+"\n";
			message += order.toString() +"\n";
		}
		else {
			message+=("FAIL! Please, check your data.");
		}
		this.notifyObservers(message);
		return res;
	}

	@Override
	public void setClosed() {
		this.order.setClosed();
	}

	@Override
	public String toString() {
		return this.order.toString();
	}

	@Override
	public void resetOrder() {
		this.order.resetOrder();
		this.notifyObservers("Undo");
	}
}
