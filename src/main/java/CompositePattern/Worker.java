package CompositePattern;

public class Worker extends Employee {
	// TODO 1: Implement the Worker class

    public Worker(String name) {
        super(name);
    }

    // TODO 3: Implement listHierarchy() for Worker

    @Override
    public void listHierarchy(int level) {
        printName(level);
    }
}
