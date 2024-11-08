package atelier2.dp.Strategy_TemplateMethod;


/**
 * Concrete IPayStrategy. Implements credit card payment method.
 */
public class PayByCreditCard extends AbstractPayStrategy {

	private String number, date, cvv;
	private static PayByCreditCard instance = null;

	public static PayByCreditCard getInstance(String number, String date, String cvv) {
		if (instance == null)
			instance = new PayByCreditCard(number, date, cvv);
		return instance;
	}

	/**
	 * Collect credit card data.
	 */
	private PayByCreditCard( String number, String date, String cvv) {
		this.number = number;
		this.date = date;
		this.cvv = cvv;
	}

	@Override
	protected boolean isSignedIn() {
		return this.isCreditCardNumberOk();
	}
	/**
	 * Validate credit card number...
	 */
	private boolean isCreditCardNumberOk() {
		/*  ...Validation on number, date, cvv ... */
		return true;
	}

	/**
	 * After card validation we can debit customer's credit card.
	 */
	@Override
	protected void paymentMethod(double paymentAmount) {
		/* ... */
	}

}

