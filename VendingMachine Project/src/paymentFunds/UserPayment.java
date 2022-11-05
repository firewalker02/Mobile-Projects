package paymentFunds;

public class UserPayment {
 static double funds=0.0; // funds deposited into machine
 static String productName="generalProduct";// name of product.
  private static volatile UserPayment user=null;
  // Constructor UserPayment
  public UserPayment(double funds, String productName){
	  this.funds=funds;
	  this.productName=productName;
  }
  /**
   * Here we use Singleton design pattern so as to ensure that only a single instance 
   * of Userpayment is created per machine
   * @return
   */
public static UserPayment getInstance() {
	if(user==null) {
		synchronized (UserPayment.class)
		{
			if(user==null)
				user=new UserPayment(funds,productName);
		}
	}
	
	return user;
}
public double getFunds() {
	return funds;
}

public void setFunds(double funds) {
	this.funds = funds;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}
  
  
}
