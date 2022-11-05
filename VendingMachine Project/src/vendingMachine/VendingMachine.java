package vendingMachine;

import State.State;
import paymentFunds.UserPayment;
import product.ProductRepo;

public class VendingMachine {
	private double totalFunds=0.0; //the total funds available
	private UserPayment userPayment; //user Payment for product instance
	private ProductRepo productRepo;
	public ProductRepo getProductRepo() {
		return productRepo;
	}
	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	private State state; //state of machine at a point in time
	/**
	 * determines cumulative funds available in machine
	 * @param funds is the amount deposited by the customer in the machine
	 */
	public void addTotalFunds(double funds) {
		this.totalFunds+=funds;
	}
	/**
	 * Returns "this" machine with the cumulative funds available
	 * @param totalFunds is the  umulative funds available
	 * @return this instance
	 */
	public VendingMachine setTotalFunds(double totalFunds) {
		this.totalFunds=totalFunds;
		return this;
	}
	/**
	 * Returns User Payment instance
	 * @return
	 */
	public UserPayment getUserPayment() {
		return userPayment;
	}
	/**
	 * sets User Payment instance
	 * @param userPayment is the instance to be set
	 */
	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}
	/**
	 * Gets the current state of the machine
	 * @return
	 */
	public State getState() {
		return this.state;
	}
	/**
	 * Sets the current state of the machine
	 * @param state is the current state too be set
	 */
public void setState(State state) {
	this.state=state;
}
public void cancelInsufficent(String product, double funds) {
	System.out.println( "We have in stock 0 items of cola");
	System.out.printf("Item %s is not available and cannot be dispensed. Your funds of %.2f dollars are returned",product,funds);
}
	/**
	 * Get total Funds of machine
	 * @return returns total Funds of Machine
	 */
	
	public void removeProduct(String productName) {
		if(this.productRepo.getAvailableProducts().get(productName).getQuantity()==0) {
			System.out.printf("We have 0 items of %s", productName);
			this.productRepo.getAvailableProducts().remove(productName);
		}
		else System.out.printf("We have %d of items of %s",this.productRepo.getAvailableProducts().get(productName).getQuantity(), productName);
			
	}
	/**
	 * Here ,we use State design pattern 
	 */
	public void dispenseChange(String productName) {
		this.state.handleState(productName);
	}
	public void cancelTransaction(String productName) {
		this.state.handleState(productName);
	}
	public double calculateChange(String productName) {
		return this.userPayment.getFunds()- productRepo.getAvailableProducts().get(productName).getPrice();
	}
	public void dispenseProduct(String productName) {
		this.state.handleState(productName);
	}
	
}
