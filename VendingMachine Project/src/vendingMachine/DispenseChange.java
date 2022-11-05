package vendingMachine;

import State.*;

public class DispenseChange implements State {
	private CareTaker careTaker;
public CareTaker getCareTaker() {
		return careTaker;
	}

	public void setCareTaker(CareTaker careTaker) {
		this.careTaker = careTaker;
	}
private static VendingMachine  vendingMachine;
//private static volatile DispenseChange change;
public DispenseChange(VendingMachine vendingMachine){
	this.vendingMachine=vendingMachine;
}


//public static DispenseChange getInstance() {
//	if(change==null) {
//		synchronized (DispenseChange.class)
//		{
//			if(change==null)
//				change=new DispenseChange(vendingMachine);
//		}
//	}
//	
//	return change;
//}
/**
 * Here,we make use of state design pattern
 */
@Override
public void handleState(String productName) {
	this.vendingMachine.removeProduct(productName);
	double change= this.vendingMachine.calculateChange(productName);
	if(change<.01)
System.out.printf("Thank you for purchasing %s.No change needed\n\n",productName);
	else
	System.out.printf("Thank you for purchasing %s.Your change is %.2f\n\n",productName,change);
	//this.vendingMachine.removeProduct(productName);
 //  this.vendingMachine.setState(new DispenseProduct(this.vendingMachine));
   this.vendingMachine.setState(careTaker.getStateFromRepo(2).getStateArchived());//Memento Design Pattern
//The above enables to get DispenseProduct state already archived
   this.vendingMachine.dispenseProduct(productName);

}
}
