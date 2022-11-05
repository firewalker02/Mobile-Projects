package vendingMachine;

import State.CareTaker;
import State.State;
import State.StateCash;
import paymentFunds.UserPayment;

public class Start implements State {
private static VendingMachine vendingMachine;
private CareTaker careTaker;
private UserPayment user;
private String welcome;
//private static volatile Start start;
public Start(VendingMachine vendingMachine){
	this.vendingMachine= vendingMachine;
}
/**
 * Here we use the strategy pattern as we call implement different algorithm versions
 * in different classes
 */
@Override
public void handleState(String productName) {
welcome(this.welcome);
//collectFunds(user.getFunds());

}
public CareTaker getCareTaker() {
	return careTaker;
}
public void setCareTaker(CareTaker careTaker) {
	this.careTaker = careTaker;
}
public UserPayment getUser() {
	return user;
}
public void setUser(UserPayment user) {
	this.user = user;
}
public void welcome(String welcome) {
	System.out.printf(welcome);
}
//public void collectFunds(double funds) {
//	this.vendingMachine.addTotalFunds(funds);
//}
public void cancelTransaction() {
	this.vendingMachine.setState(careTaker.getStateFromRepo(3));
}


//public static Start getInstance() {
//	if(start==null) {
//		synchronized (Start.class)
//		{
//			if(start==null)
//				start=new Start(vendingMachine);
//		}
//	}
//	
//	return start;
//}
public String getWelcome() {
	return welcome;
}
public void setWelcome(String welcome) {
	this.welcome = welcome;
}
}
