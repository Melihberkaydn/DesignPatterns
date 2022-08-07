package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Employee {

	// TODO 2: Implement the Supervisor class
    private List<Employee> supervisedEmployees;

    public Supervisor(String name) {
        super(name);
        supervisedEmployees = new ArrayList();
    }

    public void hireEmployee(Employee employee) {
        supervisedEmployees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        supervisedEmployees.remove(employee);
    }

    public List<Employee> getSupervisedEmployees() {
        return supervisedEmployees;
    }
    // TODO 3: Implement listHierarchy() for Supervisor


    @Override
    public void listHierarchy(int level) {
        printName(level);
        for (Employee e: supervisedEmployees
             ) {
            e.listHierarchy(level + 1);
        }
    }
}
