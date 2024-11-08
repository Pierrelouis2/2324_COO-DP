package atelier2.simulator;

import atelier2.dp.Adapter.IOrderProduct;
import atelier2.dp.Adapter.ProductAdapter;
import atelier2.dp.Observer_Decorator.IObservable;
import atelier2.dp.Observer_Decorator.IOrderObserver;
import atelier2.dp.Observer_Decorator.ObservableOrder;
import atelier2.dp.Strategy_TemplateMethod.IPayStrategy;
import atelier2.dp.Strategy_TemplateMethod.PayByPayPal;
import atelier2.model.IOrder;
import atelier2.model.Order;
import atelier2.model.ProductFactory;

public class Simulator implements ISimulator{

	private IOrderObserver consoleView;

	public Simulator(IOrderObserver consoleView) {
		this.consoleView = consoleView;
	}

	public void go() {

		ProductFactory factory = new ProductFactory();
		IOrder order = new ObservableOrder(new Order());
		String message ="";

		/* 
		 * DP Observer
		 */
		((IObservable)order).addObserver(consoleView);

		/* 
		 * Add Product
		 */
		int qty = 2;
		IOrderProduct product = new ProductAdapter(factory.createProduct(1));
		order.addProduct(product, qty);

		/* 
		 * Undo/Redo pathetic attempt
		 */
		Simulator.undo(order, product, qty, true);
		message = "Undo";
		consoleView.update(message);
		message = order.toString();
		consoleView.update(message);

		Simulator.redo(order, product, qty, true);
		message = "Redo";
		consoleView.update(message);
		message = order.toString();
		consoleView.update(message);

		order.setClosed();
		
		/* 
		 * DP Strategy
		 */
		//	IPayStrategy payStrategy = PayByCreditCard.getInstance("123456","01/25","789");
		IPayStrategy payStrategy = PayByPayPal.getInstance("abcde@cpe.fr","abcde");

		order.processOrder(payStrategy);
	}

	private static void redo(IOrder order, IOrderProduct product, int qty, boolean isAdd) {
		if(isAdd == false) 
			order.removeProduct(product, qty) ;
		else
			order.addProduct(product, qty);
	}

	private static void undo(IOrder order, IOrderProduct product, int qty, boolean isAdd) {
		if(isAdd == true) 
			order.removeProduct(product, qty) ;
		else
			order.addProduct(product, qty);

	}
}
