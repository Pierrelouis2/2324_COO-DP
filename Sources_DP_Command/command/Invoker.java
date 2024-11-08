package command;

public interface Invoker < C > {
	  void exec(C command);
	  void undo();
	  void redo();
	}
