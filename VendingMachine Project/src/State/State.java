package State;

import vendingMachine.VendingMachine;

public interface State{
	public void handleState(String productName);
//     static  VendingMachine vendingMachine = new VendingMachine();
	// static CareTaker careTaker = new CareTaker();
}
