package command;



/**
 * @author francoise.perrin
 * Inspiration : https://zenika.developpez.com/tutoriels/java/patterns-atelier1.launcher.command/
 * 
 * Dans la mise en oeuvre du DP Command avec un Invoker qui mémorise
 * l'état des objets modifiés plutôt que les commandes de modification
 * il faut que les Commandes soient capables de prendre des instantanés 
 * de l'état de leur Receiver
 */
public interface MementoableCommand extends Command {
	Memento takeSnapshot();
}
