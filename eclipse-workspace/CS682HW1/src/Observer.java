@FunctionalInterface
public interface Observer {
	public abstract void Update(Observable observable, Object arg);
}
