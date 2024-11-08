package atelier3.dp.Factories;

import atelier3.model.IOrder;
import atelier3.model.Order;
import atelier3.simulator.ISimulator;
import atelier3.simulator.Simulator1;
import atelier3.view.IView;

public class SimpleObjectFactory extends AbstractFactory{

	/*
	 * DP Singleton
	 */
	private static SimpleObjectFactory instance = null;

	public static SimpleObjectFactory getInstance() {
		if (instance == null)
			instance = new SimpleObjectFactory();
		return instance;
	}
	private SimpleObjectFactory() {
		super();
	}
	
	@Override
	public ISimulator createSimulator( IView consoleView, IFactory factory) {
		ISimulator simulator = new Simulator1(consoleView, factory);
		return simulator;
	}
	
	@Override
	public IOrder createOrder() {
		return new Order();
	}

	@Override
	public void addObserver(IOrder order, IView consoleView) {
		throw new UnsupportedOperationException();
	}
}