package atelier2.model;

import atelier2.dp.Adapter.IOrderProduct;
import atelier2.dp.Strategy_TemplateMethod.IPayStrategy;

public interface IOrder {
	public void addProduct(IOrderProduct product, int qty) ;
	public void resetOrder();
	public void removeProduct(IOrderProduct product, int qty);
	public boolean processOrder(IPayStrategy iPayStrategy);
	public void setClosed();
}

