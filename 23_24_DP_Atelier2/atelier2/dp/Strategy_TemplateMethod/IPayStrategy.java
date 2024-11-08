package atelier2.dp.Strategy_TemplateMethod;

/**
 * Common interface for all Pay strategies.
 */
public interface IPayStrategy {
	boolean pay(double paymentAmount);
}