package atelier1.model;

/**
 * Common interface for all Order.
 */
public interface IOrder {
	public void addProduct(IProduct product, int qty) ;
	public void removeProduct(IProduct product, int qty);
	public void setClosed();
	public String processOrderPayByCreditCard(String number, String date, String cvv);
	public String processOrderPayByPayPal(String email, String password);
}