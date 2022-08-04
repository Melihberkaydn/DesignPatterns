package StatePattern;

public class MovingState extends ElevatorState{

    @Override
    public void request(int floor, Controller controller) {

    }

    @Override
    public void signal(int floor, Controller controller) {
        controller.setCurrentFloor(floor);
        if (floor == controller.getNextStop()) {
            controller.getPool().remove(0);
            controller.setState(new StopState());
        }

    }

    @Override
    public String getName() {
        return "Moving";
    }
}
