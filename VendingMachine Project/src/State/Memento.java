package State;

public class Memento implements State {
private State stateArchived;
public Memento(State stateToBeArchived) {
	super();
	this.stateArchived= stateToBeArchived;
}

	public State getStateArchived() {
	return stateArchived;
}

public void setStateArchived(ActiveState stateArchived) {
	this.stateArchived = stateArchived;
}

	@Override
	public void handleState(String productName) {
		this.stateArchived.handleState(productName);
		
	}
//	public State getInstance() {
//		return this.stateArchived.getState();
//	}

}
