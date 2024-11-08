package atelier3.simulator;


import atelier3.dp.Adapter.IOrderProduct;
import atelier3.dp.ConcreteCommand_Memento.ResetCommand;
import atelier3.dp.ConcreteCommand_Memento.AddProductCommand;
import atelier3.dp.Factories.IFactory;
import atelier3.dp.Strategy_TemplateMethod.IPayStrategy;
import atelier3.dp.Strategy_TemplateMethod.PayByCreditCard;
import atelier3.dp.Strategy_TemplateMethod.PayByPayPal;
import atelier3.model.IOrder;
import atelier3.view.IView;
import command.Command;
import command.Invoker;
import command.ReplayInvoker;

public class Simulator1 implements ISimulator{

	private IFactory factory;
	private IView consoleView;
	private Invoker<Command> invoker ;

	public Simulator1(IView consoleView, IFactory factory) {

		this.factory = factory;
		this.consoleView = consoleView;
	}

	public void go() {

		IOrder order;
		order = factory.createOrder();
		String message;

//		invoker = new MementoInvoker<Command>();
		this.invoker = new ReplayInvoker<Command>(new ResetCommand(order));
		
		int qty = 2;
		IOrderProduct product = factory.createProduct(1);
		Command command = new AddProductCommand(order, product, qty);
		invoker.exec(command);
		message = "Add " + qty + " " + product.getName() + " " + product.getPrice();
		consoleView.update(message);
		
		invoker.undo();
		consoleView.update("Undo");
		invoker.redo();
		consoleView.update(message);
		
		order.setClosed();

		IPayStrategy payStrategy = PayByCreditCard.getInstance("123456","01/25","789");
//		IPayStrategy payStrategy = PayByPayPal.getInstance("abcde@cpe.fr","abcde");

		boolean bool = order.processOrder(payStrategy);
		if (bool) {
			message = "\n" + payStrategy + " has been successful"+"\n";
			message += order.toString() +"\n";
		}
		else {
			message=("FAIL! Please, check your data.");
		}
		consoleView.update(message);
	}
}

