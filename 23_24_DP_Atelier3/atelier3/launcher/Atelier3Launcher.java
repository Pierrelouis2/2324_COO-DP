package atelier3.launcher;

import java.io.IOException;

import atelier3.dp.Factories.IFactory;
import atelier3.dp.Factories.SimpleObjectFactory;
import atelier3.dp.Factories.WrappedObjectFactory;
import atelier3.simulator.ISimulator;
import atelier3.view.IView;

/**
 * Console e-commerce application.
 */
public class Atelier3Launcher {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Atelier3\n");
		
//		IFactory factory = SimpleObjectFactory.getInstance();
		IFactory factory = WrappedObjectFactory.getInstance();

		IView consoleLog = factory.createView();
		ISimulator simulator = factory.createSimulator(consoleLog, factory);

		simulator.go();
	}
}
