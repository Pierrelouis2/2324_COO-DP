package command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author francoise.perrin
 * Inspiration : https://zenika.developpez.com/tutoriels/java/patterns-atelier1.launcher.command/
 *
 * Cet Invoker est utilisé de le cadre de la mise en oeuvre du DP Command
 * en mode "Compensation"
 * il stocke des CompensableCommand qui peuvent ainsi être jouées (execute)
 * et rejouées ("redo") ou compensées ("undo") 
 * 
 * 
 * @param <C>
 */
public class CompensationInvoker < C extends Command > implements  Invoker< C > {
    
    private final Deque< C > undos = new LinkedList< C >();
    private final Deque< C > redos = new LinkedList< C >();
    
    @Override public void undo() {
        showStacks("before Undo");
        C latestCommand = undos.pollLast();
        if(latestCommand == null) 
            return;
        redos.addLast(latestCommand);
        ((CompensableCommand) latestCommand).compensate();
        showStacks("after Undo");
    }

    @Override public void redo() {
        showStacks("before Redo");
        C latestCommand = redos.pollLast();
        if(latestCommand==null) 
            return;
        latestCommand.execute();
        undos.addLast(latestCommand);
        showStacks("after Redo");
    }

    @Override
    public void exec(C command) {
        showStacks("before Exec");
        command.execute();
        undos.addLast(command);
        redos.clear();
        showStacks("after Exec");
    }

    private void showStacks(String when) {
    /*
    // Dé-commenter pour activer les traces
        System.out.println(
                when + "\n" +
                "Undos : " + undos.toString() + "\n" +
                "Redos : " + redos.toString() + "\n" +
                "---------------"
                
                );
    */
    }
    
}

