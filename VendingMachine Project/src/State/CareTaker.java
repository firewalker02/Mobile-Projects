package State;
	import java.util.*;
	public class CareTaker {
	private List<Memento> mementoList = 
	new ArrayList<Memento>();
	
	public void addStateToRepo(Memento memento){
	mementoList.add(memento);
	}
	
	public Memento getStateFromRepo(int index){
	return mementoList.get(index);
	}
	}
