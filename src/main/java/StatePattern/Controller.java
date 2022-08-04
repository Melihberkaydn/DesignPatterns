package StatePattern;

import java.util.LinkedList;
import java.util.List;

public class Controller {


	private ElevatorState state;
	private int currentFloor;
	List<Integer> pool;

	public Controller(int currentFloor) {
		state = new IdleState();
		this.currentFloor = currentFloor;
		this.pool = new LinkedList<>();
	}

	public void request(int floor) {
		pool.add(floor);
		state.request(floor, this);
	}

	public void signal(int floor) {
		state.signal(floor, this);
	}

	public ElevatorState getState() {
		return state;
	}

	public int getNextStop() {
		return pool.get(0);
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public List<Integer> getPool() {
		return pool;
	}

	public void setState(ElevatorState state) {
		this.state = state;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
}
