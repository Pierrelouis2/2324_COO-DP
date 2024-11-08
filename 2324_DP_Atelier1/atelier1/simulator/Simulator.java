package atelier1.simulator;

import atelier1.model.IOrder;
import atelier1.model.IProduct;
import atelier1.model.Order;
import atelier1.model.Product;
import atelier1.model.ProductFactory;
import atelier1.view.IView;

public class Simulator implements ISimulator{


	private IView consoleView;

	public Simulator(IView consoleView) {	
		this.consoleView = consoleView;
	}

	public void go() {

		ProductFactory factory = new ProductFactory();
		IOrder order = new Order();
		String message;

		int qty = 2;
		IProduct product = factory.createProduct(1);

		/* 
		 * add a product
		 */
		order.addProduct(product, qty);
		message = "Add " + qty + " " + product.getName() + " " + product.getPrice();
		consoleView.update(message);
		message = order.toString();
		consoleView.update(message);

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


		message = order.processOrderPayByCreditCard("123456","01/25","789");
		consoleView.update(message);

		message = order.processOrderPayByPayPal("abcde@cpe.fr","abcde");
		consoleView.update(message);

	}

	private static void redo(IOrder order, IProduct product, int qty, boolean isAdd) {
		if(isAdd == false) 
			order.removeProduct(product, qty) ;
		else
			order.addProduct(product, qty);
	}

	private static void undo(IOrder order, IProduct product, int qty, boolean isAdd) {
		if(isAdd == true) 
			order.removeProduct(product, qty) ;
		else
			order.addProduct(product, qty);
	}
}
