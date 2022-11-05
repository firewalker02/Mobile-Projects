package vendingMachine;

import State.CareTaker;
import State.State;


public class DispenseProduct implements State {
//private static VendingMachine  vendingMachine;
private  VendingMachine  vendingMachine;
private CareTaker careTaker ;
public CareTaker getCareTaker() {
	return careTaker;
}
public void setCareTaker(CareTaker careTaker) {
	this.careTaker = careTaker;
}
//private static volatile DispenseProduct dispense;
public DispenseProduct(VendingMachine vendingMachine){
	this.vendingMachine=vendingMachine;
}
/**
 * Here we are using state design pattern transferring from one state to another 
 * between the state classes
 */
@Override
public void handleState(String productName) {
	//this.vendingMachine.removeProduct(productName);
	System.out.printf("Transaction ended with item %s",productName);
   //this.vendingMachine.setState(new Start(this.vendingMachine));
    this.vendingMachine.addTotalFunds(this.vendingMachine.getUserPayment().getFunds());
  this.vendingMachine.getProductRepo().diminishQuantity(productName);
this.vendingMachine.setState(careTaker.getStateFromRepo(0));


}

/**
 * Here we make use of Singleton design pattern to retrieve a unique instance
 * @return
 */
//public static DispenseProduct getInstance() {
//	if(dispense==null) {
//		synchronized (DispenseProduct.class)
//		{
//			if(dispense==null)
//				dispense=new DispenseProduct(vendingMachine);
//		}
//	}
//	
//	return dispense;
//}
}
