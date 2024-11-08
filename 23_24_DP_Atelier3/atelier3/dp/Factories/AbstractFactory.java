package atelier3.dp.Factories;

import java.util.HashMap;
import java.util.Map;


import atelier3.dp.Adapter.IOrderProduct;
import atelier3.dp.Adapter.ProductAdapter;
import atelier3.model.IOrder;
import atelier3.model.IProduct;
import atelier3.model.Product;
import atelier3.model.ProductFactory;
import atelier3.view.IView;
import atelier3.view.ViewConsole;


public abstract class AbstractFactory implements IFactory{

//	protected static Map<Integer, IProduct> PRODUCT_DATA_BASE = new HashMap<Integer, IProduct>();
//	static {
//		PRODUCT_DATA_BASE.put(1,new Product(1, "Produit1", 100.0,"BlaBla1"));
//		PRODUCT_DATA_BASE.put(2,new Product(2, "Produit2", 200.0,"BlaBla2"));
//		PRODUCT_DATA_BASE.put(3,new Product(3, "Produit3", 300.0,"BlaBla3"));
//		PRODUCT_DATA_BASE.put(4,new Product(4, "Produit4", 400.0,"BlaBla4"));
//	}
	
	ProductFactory productFactory;
	
	protected AbstractFactory() {
		productFactory = new ProductFactory();
	}
	
	@Override
	public abstract IOrder createOrder();
	public abstract void addObserver(IOrder order, IView consoleView);

	@Override
	public final IOrderProduct createProduct(int id) {
		IProduct product = null;
		product = (IProduct) productFactory.createProduct(id) ;
		return new ProductAdapter(product);
	}

	@Override
	public IView createView() {
		IView view = new ViewConsole();
		return view;
	}
	
}