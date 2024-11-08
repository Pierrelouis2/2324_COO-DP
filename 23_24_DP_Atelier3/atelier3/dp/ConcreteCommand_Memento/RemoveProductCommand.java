package atelier3.dp.ConcreteCommand_Memento;


import atelier3.dp.Adapter.IOrderProduct;
import atelier3.model.IOrder;
import command.Command;

public class RemoveProductCommand implements Command {

	private IOrder order;
	private IOrderProduct product;
	private int qty;

	public RemoveProductCommand(IOrder order, IOrderProduct product, int qty ) {
		this.order = order;
		this.product = product;
		this.qty = qty;
	}

	@Override
	public void execute() {
		this.order.removeProduct(product, qty);
	}
}