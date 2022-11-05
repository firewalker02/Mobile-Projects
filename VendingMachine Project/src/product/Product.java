package product;

public abstract class Product {
   protected double price;
   String productName; // name of different product category
  protected int quantity;
   //product constructor
   Product(String productName, int quantity, double price){
	   this.productName= productName;
	   this.quantity=quantity;
	   this.price=price;
   }
   boolean itemInStock(String productName, int quantity) {
	   boolean inStock= false;
	   if(quantity==0)
		   inStock= false;
	   else
		   inStock=true;
	   if(quantity==1)
	   System.out.printf("We have in stock 1 item of %s", productName);
	   else
		System.out.printf("We have in stock %d items of %s", quantity,productName);
  return inStock;
   }
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
   
}
