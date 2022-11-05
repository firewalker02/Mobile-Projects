package State;

public class ObjectState {
private ActiveState activeState;

public void setObjState(ActiveState activeState) {
	this.activeState=activeState;
	// TODO Auto-generated method stub	
}
public ActiveState getActiveState() {
	return this.activeState;
}
}
