package vendingMachine;

import State.*;

public class CancelTransaction implements State{
//private static VendingMachine vendingMachine;
private  VendingMachine vendingMachine;

//private static volatile CancelTransaction cancel=null;

private CareTaker careTaker;
public CareTaker getCareTaker() {
	return careTaker;
}
public void setCareTaker(CareTaker careTaker) {
	this.careTaker = careTaker;
}
public CancelTransaction(VendingMachine vendingMachine){
	this.vendingMachine=vendingMachine;
  //	careTaker=new CareTaker();
}
/**
 * Here we make use of Singleton design pattern to retrieve a unique instance
 * @return
 */
//public static CancelTransaction getInstance() {
//	if(cancel==null) {
//		synchronized (CancelTransaction.class)
//		{
//			if(cancel==null)
//				cancel=new CancelTransaction(vendingMachine);
//		}
//	}
//	
//	return cancel;
//}/**
/**
 * Here we make use of state design pattern
 */
	@Override
	public void handleState(String productName) {
		
	System.out.printf("Insufficient funds for item %s.You have provided %.2f dollars.Item costs %.2f dollars.Funds returned\n",productName,vendingMachine.getUserPayment().getFunds(),vendingMachine.getProductRepo().getAvailableProducts().get(productName).getPrice());
	//vendingMachine.setState(new Start(vendingMachine);
 this.vendingMachine.setState(careTaker.getStateFromRepo(0));
// TODO Auto-generated method stub
		
	}

}
