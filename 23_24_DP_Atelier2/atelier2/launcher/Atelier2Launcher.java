package atelier2.launcher;

import java.io.IOException;

import atelier2.simulator.ISimulator;
import atelier2.simulator.Simulator;
import atelier2.view.IView;
import atelier2.view.ViewConsole;



/**
 * Console e-commerce application.
 */
public class Atelier2Launcher {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Atelier2\n");
		
		IView consoleLog = new ViewConsole();
		ISimulator simulator = new Simulator(consoleLog);
		
		simulator.go();
	}
}
