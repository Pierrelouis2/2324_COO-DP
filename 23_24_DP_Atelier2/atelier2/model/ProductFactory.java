package atelier2.model;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {

	protected static Map<Integer, IProduct> PRODUCT_DATA_BASE = new HashMap<Integer, IProduct>();
	static {
		PRODUCT_DATA_BASE.put(1,new Product(1, "Produit1", 100.0,"BlaBla1"));
		PRODUCT_DATA_BASE.put(2,new Product(2, "Produit2", 200.0,"BlaBla2"));
		PRODUCT_DATA_BASE.put(3,new Product(3, "Produit3", 300.0,"BlaBla3"));
		PRODUCT_DATA_BASE.put(4,new Product(4, "Produit4", 400.0,"BlaBla4"));
	}

	public final IProduct createProduct(int id) {
		IProduct product= null;
		product = PRODUCT_DATA_BASE.get(id);
		return product;
	}
}
