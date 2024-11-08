package command;



/**
 * Inspiration : https://zenika.developpez.com/tutoriels/java/patterns-atelier1.launcher.command/
 * 
 * Cette interface définit le comportement attendu de tout objet 
 * capable de sauver et de restaurer l'état d'un objet auquel 
 * il est très fortement couplé
 * Dans notre contexte, il s'agit de pouvoir restaurer l'état des attributs 
 * de la classe GuiConfig en cas de "undo" ou "redo"
 */
@FunctionalInterface
public interface Memento {
	void restore();
}
