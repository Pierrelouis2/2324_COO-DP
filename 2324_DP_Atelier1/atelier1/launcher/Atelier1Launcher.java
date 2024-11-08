package atelier1.launcher;

import java.io.IOException;
import atelier1.simulator.ISimulator;
import atelier1.simulator.Simulator;
import atelier1.view.IView;
import atelier1.view.ViewConsole;

/**
 * Console e-commerce application.
 */
public class Atelier1Launcher {

	public static void main(String[] args) throws IOException {

		System.out.println("Atelier1\n");

		IView consoleLog = new ViewConsole();
		ISimulator simulator = new Simulator(consoleLog);
		simulator.go();
	}
}
