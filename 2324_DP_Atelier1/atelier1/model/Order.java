package atelier1.model;

import java.util.HashMap;
import java.util.Map;



public class Order implements IOrder {

	private Map<IProduct, Integer> products;
	private int totalCost;
	private boolean isClosed;

	public Order(){
		this.products = new HashMap<IProduct, Integer>();
		this.totalCost = 0;
		this.isClosed = false;
	}

	@Override
	public void addProduct(IProduct product, int qty) {

		int count = 0;
		if (this.products.containsKey(product)) {
			count = this.products.get(product);
		}
		count += qty;
		this.products.put(product,count);
		this.totalCost += product.getPrice() * qty;
	}

	@Override
	public void removeProduct(IProduct product, int qty) {
		int count = this.products.get(product);
		if (count != 0) { 
			if (qty < count) {
				this.products.put(product,count-qty);
				this.totalCost -= product.getPrice() * qty;
			}
			else{
				this.totalCost -= product.getPrice() * count;
				this.products.remove(product);
			}
		}
	}

	@Override
	public void setClosed() {
		isClosed = true;
	}

	@Override
	public String toString() {
		return "Order [ShoppingCart = " + products + "\n TotalCost = " + totalCost + "]";
	}

	@Override
	public String processOrderPayByCreditCard(String number, String date, String cvv) {
		String message = "";
		boolean res = false;
		
		/**
		 * After card validation we can debit customer's paypal account.
		 */	
		if (this.isClosed && this.totalCost != 0.0) {
			res = true; /* ...Validation on number, date, cvv ...;*/
			
			if (res ){
				/* ... Pay by Card payment method	*/
				
				message += "\nPayByCard has been successful";
				message += this.toString();
			}
			else {
				message+=("\nFAIL! Please, check your data.");
			}
		}		
		return message;
	}

	@Override
	public String processOrderPayByPayPal(String email, String password) {
		String message = "";
		boolean res = false;
		
		/**
		 * ...
		 */	
		Map<String, String> PAYPAL_DATA_BASE = new HashMap<>();
		PAYPAL_DATA_BASE.put("abcde", "abcde@cpe.fr");
		PAYPAL_DATA_BASE.put("fgh", "fgh@cpe.fr");

		/**
		 * After login validation we can debit customer's paypal account.
		 */	
		if (this.isClosed && this.totalCost != 0.0) {
			res = email.equals(PAYPAL_DATA_BASE.get(password));

			if (res ){
				/* ... PayPal payment method	*/

				message += "\nPayByPayPal has been successful";
				message += this.toString();
			}
			else {
				message+=("\nFAIL! Please, check your data.");
			}
		}
		return message;
	}

}
