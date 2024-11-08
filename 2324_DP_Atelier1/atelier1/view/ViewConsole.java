package atelier1.view;



public class ViewConsole implements IView {

	@Override
	public void update(String message) {
		System.out.println(message);
	}
}