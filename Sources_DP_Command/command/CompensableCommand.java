package command;



/**
 * @author francoise.perrin
 * Inspiration : https://zenika.developpez.com/tutoriels/java/patterns-atelier1.launcher.command/
 * 
 * Dans la mise en oeuvre du DP Command avec un Invoker qui mémorise
 * les commandes en mode "Compensation"
 * il faut que les Commandes soient capables d'être compensées
 * 
 */
public interface CompensableCommand extends Command {
	  void compensate();
	
}

