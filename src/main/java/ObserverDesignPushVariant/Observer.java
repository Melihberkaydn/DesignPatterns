package ObserverDesignPushVariant;

public interface Observer<T> {

	void onUpdate(T newState);
}
