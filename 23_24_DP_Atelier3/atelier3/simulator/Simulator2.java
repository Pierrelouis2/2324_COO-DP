package atelier3.simulator;

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

public class Simulator2 implements ISimulator{

	private IFactory factory;
	private IView consoleView;
	private Invoker<Command> invoker ;

	public Simulator2(IView consoleView, IFactory factory) {

		this.factory = factory;
		this.consoleView = consoleView;
	}

	public void go() {

		IOrder order;
		order = factory.createOrder();	

		try {
			factory.addObserver(order, consoleView);
		} catch (Exception e) {
			/* order pas observable => pas d'affichage en console */
		}

//		invoker = new MementoInvoker<Command>();
		this.invoker = new ReplayInvoker<Command>(new ResetCommand(order));

		Command command = new AddProductCommand(order, factory.createProduct(1), 2);
		invoker.exec(command);
		invoker.undo();
		invoker.redo();

		order.setClosed();

//		IPayStrategy payStrategy = PayByCreditCard.getInstance("123456","01/25","789");
		IPayStrategy payStrategy = PayByPayPal.getInstance("abcde@cpe.fr","abcde");

		order.processOrder(payStrategy);

	}
}
