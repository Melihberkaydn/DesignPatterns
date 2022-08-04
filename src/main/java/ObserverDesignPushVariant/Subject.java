package ObserverDesignPushVariant;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Subject<T> {

	private final Set<Observer<T>> observers = new HashSet<>();

	public void addObserver(Observer<T> observer) {
		Objects.requireNonNull(observer);
		observers.add(observer);
	}

	public void removeObserver(Observer<T> observer) {
		Objects.requireNonNull(observer);
		observers.remove(observer);
	}

	protected void notifyObservers(final T newState) {
		for (Observer O: observers
			 ) {
			O.onUpdate(newState);
		}
	}
}
