package client;
import java.util.*;
import java.io.*;
import product.*;
import vendingMachine.*;
import State.*;
import paymentFunds.UserPayment;
public class Client {
	public static void main(String[] args) {
		
	
VendingMachine vendingMachine=new VendingMachine();
Product drinkA=new DrinkTypeA("Cola",2,10);
Product drinkB=new DrinkTypeB("Juice",3,20);
ProductRepo productRepo=new ProductRepo();
HashMap<String,Product> availableProducts=new HashMap<>();
availableProducts.put(drinkA.getProductName(),drinkA);
availableProducts.put(drinkB.getProductName(),drinkB);
productRepo.setAvailableProducts(availableProducts);
vendingMachine.setProductRepo(productRepo);
Start startState= new Start(vendingMachine);
DispenseChange dispenseChange=new DispenseChange(vendingMachine);
DispenseProduct dispenseProduct=new DispenseProduct(vendingMachine);
CancelTransaction cancelTransaction=new CancelTransaction(vendingMachine);
//Memento design pattern 
/**
 * From lines 29-44 ,we use Memento design pattern to store objects and retrive them
 */
ObjectState objState=new ObjectState();
ActiveState activeStateDefault=new ActiveState();
activeStateDefault.setState(startState);
objState.setObjState(activeStateDefault);
//current active object is Start
CareTaker aCareTaker=new CareTaker();
Originator anOriginator = new Originator();
Memento defaultMemento = 
anOriginator.saveStateToMemento(activeStateDefault);
Memento changeMemento= anOriginator.saveStateToMemento(dispenseChange);
Memento productMemento= anOriginator.saveStateToMemento(dispenseProduct);
Memento cancelMemento= anOriginator.saveStateToMemento(cancelTransaction);
aCareTaker.addStateToRepo(defaultMemento);
aCareTaker.addStateToRepo(changeMemento);
aCareTaker.addStateToRepo(productMemento);
aCareTaker.addStateToRepo(cancelMemento);
startState.setCareTaker(aCareTaker); dispenseChange.setCareTaker(aCareTaker);
dispenseProduct.setCareTaker(aCareTaker);cancelTransaction.setCareTaker(aCareTaker);

UserPayment user;
String s="---------------\n Welcome to the vending machine\n-------------\n\n\n Press any key to continue";
startState.setWelcome(s);
Scanner obj = null;
try  {
	obj = new Scanner(System.in);
	List<Product> list= new ArrayList<>();
	list.add(drinkA);list.add(drinkB);
	vendingMachine.setState(startState);
	
	while(true) {
	boolean f=false;
	for(Product p: list)
		if(p.getQuantity()!=0) {
			f=true;
			break;
		}

	if(f==false)
		break;
	startState.welcome(s);
	obj.nextLine();
	
	System.out.printf("\nPlease select item to purchase(%s, %s, %s)\n",drinkA.getProductName(),drinkB.getProductName(),"Water");
	String productName=obj.nextLine();
	double price=productRepo.getAvailableProducts().get(productName).getPrice();
	System.out.printf("\nPlease deposit money. Your selection costs %.2f dollars\n",productRepo.getAvailableProducts().get(productName).getPrice());
	double money=obj.nextDouble();
	user=UserPayment.getInstance();
	user.setFunds(money);
	user.setProductName(productName);
	vendingMachine.setUserPayment(user);
	if(money>=price) {
		vendingMachine.setState(dispenseChange);
		vendingMachine.dispenseChange(productName);
	}
	else if (vendingMachine.getProductRepo().ExactQuantity(productName)==0)
		vendingMachine.cancelInsufficent(productName,money);
	
	else 
		vendingMachine.cancelTransaction(productName);
	
}
	}
catch(Exception e){
e.printStackTrace();
}

obj.close();
	}
}

