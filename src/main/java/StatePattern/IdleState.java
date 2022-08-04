package StatePattern;

public class IdleState extends ElevatorState{

    @Override
    public void request(int floor, Controller controller) {
        controller.setState(new MovingState());
    }

    @Override
    public void signal(int floor, Controller controller) {

    }

    @Override
    public String getName() {
        return "Idle";
    }
}
