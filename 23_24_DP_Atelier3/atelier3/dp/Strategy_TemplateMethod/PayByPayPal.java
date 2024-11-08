package atelier3.dp.Strategy_TemplateMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete IPayStrategy. Implements Paypal payment method.
 */
public class PayByPayPal extends AbstractPayStrategy {

	private static final Map<String, String> PAYPAL_DATA_BASE = new HashMap<>();
	static {
		PAYPAL_DATA_BASE.put("abcde", "abcde@cpe.fr");
		PAYPAL_DATA_BASE.put("fgh", "fgh@cpe.fr");
	}
	private String email;
	private String password;

	private static PayByPayPal instance = null;

	public static PayByPayPal getInstance(String email, String password) {
		if (instance == null)
			instance = new PayByPayPal(email, password);
		return instance;
	}


	/**
	 * Collect customer's data.
	 */
	private PayByPayPal(String email, String password){
		this.email=email;
		this.password = password;
	}

	@Override
	protected boolean isSignedIn() {
		return this.email.equals(PAYPAL_DATA_BASE.get(this.password));

	}
	/**
	 * After login validation we can debit customer's paypal account.
	 */
	@Override
	protected void paymentMethod(double paymentAmount) {
		/* ... */
	}

}

