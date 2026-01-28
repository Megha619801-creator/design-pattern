package composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {

    private List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    @Override
    public double getTotalSalary() {
        double total = 0;
        for (OrganizationComponent component : children) {
            total += component.getTotalSalary();
        }
        return total;
    }

    @Override
    public void printXML(String indent) {
        System.out.println(indent + "<department name=\"" + name + "\">");

        for (OrganizationComponent component : children) {
            component.printXML(indent + "  ");
        }

        System.out.println(indent + "</department>");
    }
}
