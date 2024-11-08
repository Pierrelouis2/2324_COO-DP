package atelier3.dp.Factories;

import atelier3.dp.Observer_Decorator.ObservableOrder;
import atelier3.model.IOrder;
import atelier3.model.Order;
import atelier3.simulator.ISimulator;
import atelier3.simulator.Simulator2;
import atelier3.view.IView;

public class WrappedObjectFactory extends AbstractFactory{

	/*
	 * DP Singleton
	 */
	private static WrappedObjectFactory instance = null;

	public static WrappedObjectFactory getInstance() {
		if (instance == null)
			instance = new WrappedObjectFactory();
		return instance;
	}
	private WrappedObjectFactory() {
		super();
	}
	
	@Override
	public ISimulator createSimulator( IView consoleView, IFactory factory) {
		ISimulator simulator = new Simulator2(consoleView, factory);
		return simulator;
	}
	
	@Override
	public IOrder createOrder() {
		return new ObservableOrder(new Order());
	}

	@Override
	public void addObserver(IOrder order, IView consoleView) {
		((ObservableOrder)order).addObserver(consoleView);
	}
}