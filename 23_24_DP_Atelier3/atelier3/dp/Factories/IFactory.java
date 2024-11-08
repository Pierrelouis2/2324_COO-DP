package atelier3.dp.Factories;

import atelier3.dp.Adapter.IOrderProduct;
import atelier3.model.IOrder;
import atelier3.simulator.ISimulator;
import atelier3.view.IView;

public interface IFactory {
	public IOrder createOrder();
	public IOrderProduct createProduct(int id);
	public IView createView();
	public ISimulator createSimulator(IView consoleView, IFactory factory);
	public void addObserver(IOrder order, IView consoleView);
}