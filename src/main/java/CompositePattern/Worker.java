package CompositePattern;

public class Worker extends Employee {

    public Worker(String name) {
        super(name);
    }

    @Override
    public void listHierarchy(int level) {
        printName(level);
    }
}
