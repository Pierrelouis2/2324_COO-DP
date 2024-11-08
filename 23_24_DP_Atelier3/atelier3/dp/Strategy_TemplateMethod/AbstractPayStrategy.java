package atelier3.dp.Strategy_TemplateMethod;

/**
 * Concrete IPayStrategy. Implements PayPal payment method.
 */
public abstract class AbstractPayStrategy implements IPayStrategy {

	/**
	 * Payment Template Method.
	 */
	@Override
	public final boolean pay(double paymentAmount) {
		if (this.isSignedIn()) {
			this.paymentMethod(paymentAmount);
			return true;
		} else {
			return false;
		}
	}

	protected abstract boolean isSignedIn();
	protected abstract void paymentMethod(double paymentAmount);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

