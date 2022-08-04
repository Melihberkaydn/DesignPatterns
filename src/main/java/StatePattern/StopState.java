package StatePattern;

public class StopState extends ElevatorState {

    @Override
    public void request(int floor, Controller controller) {

    }

    @Override
    public void signal(int floor, Controller controller) {
        if (controller.getPool().size() == 0)  {
            controller.setState(new IdleState());
        }
        else {
            controller.setState(new MovingState());
        }

    }

    @Override
    public String getName() {
        return "Stop";
    }
}
