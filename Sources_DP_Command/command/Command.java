package command;



/**
 * @author francoise.perrin
 * Inspiration : https://zenika.developpez.com/tutoriels/java/patterns-atelier1.launcher.command/
 * 
 * Dans la mise en oeuvre du DP Command toutes les commandes doivent être exécutables
 * 
 */
public interface Command {
	  void execute();
}