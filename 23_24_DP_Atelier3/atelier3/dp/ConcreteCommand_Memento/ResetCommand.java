package atelier3.dp.ConcreteCommand_Memento;

import atelier3.model.IOrder;
/**
 * @author francoiseperrin
 * 
 * Command qui permet de réinitialiser l'Ãétat des attributs de l'objet Order
 * en cas d'utilisation de la Strategy Replay lors d'un "rollback" (menu undo)
 *
 */
import command.Command;

public class ResetCommand implements Command {

	IOrder order;
	public ResetCommand(IOrder order ) {
		this.order = order;
	}

	@Override
	public void execute() {
		order.resetOrder();
	}	
}
