package atelier3.dp.Adapter;

import atelier3.model.IProduct;

public class ProductAdapter implements IOrderProduct {
	IProduct product;

	public ProductAdapter(IProduct product) {
		super();
		this.product = product;
	}

	@Override
	public int getId() {
		return product.getId();
	}
	@Override
	public String getName() {
		return this.product.getName();
	}
	public double getPrice() {
		return this.product.getPrice();
	}

	@Override
	public String toString() {
		return  " ["+ this.product.getName() + ", " + this.product.getPrice()  + "]";
	}

	@Override
	public int hashCode() {
	
		return product.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		 
		return product.equals(obj);
	}

}

