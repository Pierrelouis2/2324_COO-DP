package atelier3.model;

import java.util.HashMap;
import java.util.Map;

import atelier3.dp.Adapter.IOrderProduct;
import atelier3.dp.Strategy_TemplateMethod.IPayStrategy;


/**
 * Order class. Doesn't know the concrete payment method (strategy) user has
 * picked. It uses common strategy interface to delegate collecting payment data
 * to strategy object. It can be used to save order to database.
 */
public class Order implements IOrder {

	private Map<IOrderProduct, Integer> products;
	private int totalCost;
	private boolean isClosed;

	public Order() {
		this.products = new HashMap<IOrderProduct, Integer>();
		this.resetOrder();
	}
	
	@Override
	public void resetOrder() {
		this.products.clear();
		this.totalCost = 0;
		this.isClosed = false;
	}

	@Override
	public boolean processOrder(IPayStrategy iPayStrategy) {

		boolean res = false;
		if (this.isClosed && this.totalCost != 0.0) {
			res = iPayStrategy.pay(this.totalCost);
		}
		return res;
	}

	@Override
	public void addProduct(IOrderProduct product, int qty) {

		int count = 0;
		if (this.products.containsKey(product)) {
			count = this.products.get(product);
		}
		count += qty;
		this.products.put(product,count);
		this.totalCost += product.getPrice() * qty;
	}

	@Override
	public void removeProduct(IOrderProduct product, int qty) {
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

}
