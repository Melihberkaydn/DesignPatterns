package CompositePattern;

public final class EmployeeOverviewSystem {

	private EmployeeOverviewSystem() {
	}

	public static void main(String[] args) {

		Supervisor ceo = new Supervisor("Chief Zed");
		ceo.hireEmployee(new Worker("Molly Wright"));
		ceo.hireEmployee(new Worker("Derrick Cunningham"));

		Supervisor supervisor1 = new Supervisor("Kevin Brown");
		supervisor1.hireEmployee(new Worker("James Edwards"));
		supervisor1.hireEmployee(new Worker("Laurel Weaver"));

		ceo.hireEmployee(supervisor1);

		ceo.listHierarchy(0);


	}

}
