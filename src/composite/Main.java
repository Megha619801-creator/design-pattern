package composite;

public class Main {

    public static void main(String[] args) {

        Department root = new Department("Company");

        Department it = new Department("IT");
        Department hr = new Department("HR");

        Employee e1 = new Employee("Alice", 5000);
        Employee e2 = new Employee("Bob", 6000);
        Employee e3 = new Employee("Charlie", 4000);

        it.add(e1);
        it.add(e2);
        hr.add(e3);

        root.add(it);
        root.add(hr);

        System.out.println("Total salary: " + root.getTotalSalary());

        System.out.println("\nOrganization Structure (XML):");
        root.printXML("");
    }
}

