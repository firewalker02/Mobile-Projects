package State;

public class ActiveState implements State {
//private String stateName;
private State state;

@Override
public void handleState(String productName) {
	this.state.handleState(productName);
	// TODO Auto-generated method stub	
}

public void setState(State startState) {
	this.state=startState;
	// TODO Auto-generated method stub	
}
public State getState() {
	return this.state;
}


}
