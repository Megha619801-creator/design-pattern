package composite;

public  abstract class OrganizationComponent {
    protected String name;
    OrganizationComponent(String name){
        this.name = name;
    }
    public void add(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }
    public void remove (OrganizationComponent component){
        throw new UnsupportedOperationException();
    }
    public abstract double getTotalSalary();
    public abstract void printXML(String indent);
}
