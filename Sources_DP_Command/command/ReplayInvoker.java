package command;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author francoise.perrin
 * Inspiration : https://zenika.developpez.com/tutoriels/java/patterns-atelier1.launcher.command/
 *
 * Cet Invoker est utilisé de le cadre de la mise en oeuvre du DP Command 
 * en mode "Replay"
 * Il stocke des Command qui seront toutes rejouées sauf la dernière en cas de "undo" 
 * ("redo") ou compensées ("undo") 
 * La commande annulée en cas de "undo" pourra être réexécutée en cas de "redo"
 * 
 * Petite subtilité, il a besoin d'une Command de réinitialisation de l'état initial 
 * du Receiver pour chaque "undo"
 * 
 * @param <C>
 */
public class ReplayInvoker < C extends Command > implements  Invoker< C > {

	private final Deque< C > undos = new LinkedList< C >();
	private final Deque< C > redos = new LinkedList< C >();

	private final Command reset;

	public ReplayInvoker(Command reset) {
		this.reset = reset;
	}

	@Override 
	public void exec(C command) {
		command.execute();
		undos.addLast(command);
		redos.clear();

	}

	@Override public void undo() {
		C latestCmd = undos.pollLast() ;
		if(latestCmd==null) return;
		redos.addLast(latestCmd);
		reset.execute();
		for(C command : undos) {
			command.execute();
		}

	}

	@Override public void redo() {
		C latestCmd = redos.pollLast() ;
		if(latestCmd==null) return;
		latestCmd.execute();
		undos.addLast(latestCmd); 
	}

}
