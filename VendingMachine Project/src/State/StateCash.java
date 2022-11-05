package State;
/**
 * Here we start applying the notion of state design pattern, we create different methods
 * below which reperesent the different states of the machine once an operation is initiated
 * on the machine(E.g buying a new drink or snack)
 * @author Ursanne Kengne
 *
 */
public interface StateCash {
  public void insertCash(double amount);

}
