package ObserverPatternPushVariant2;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<T> {
    // TODO realize observer pattern

    List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    };
    public void unsubscribe(Observer<T> observer) {
        observers.remove(observer);
    };

    void notifyObservers() {
        T update = getUpdate();

        for (Observer o: observers
             ) {
            o.update(update);
        }
    }

    abstract T getUpdate();

}
