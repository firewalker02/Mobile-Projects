package product;
import java.util.*;

public class ProductRepo {
  HashMap<String,Product> availableProducts;
public ProductRepo(){
	availableProducts=new HashMap<>();
}
public HashMap<String, Product> getAvailableProducts() {
	return availableProducts;
}

public void setAvailableProducts(HashMap<String, Product> availableProducts) {
	this.availableProducts = availableProducts;
}
  public void diminishQuantity(String product) {
	  availableProducts.get(product).setQuantity(availableProducts.get(product).getQuantity()-1);
  }
  public int ExactQuantity(String product) {
	  return availableProducts.get(product).getQuantity();
  }
}
