package State;

public class Originator {
	public Memento saveStateToMemento(State
			state) {
			Memento aMemento = new Memento(state);
			return aMemento;
			}
			public State getStateFromMemento(Memento 
			memento) {
			return memento.getStateArchived();
			}

}
