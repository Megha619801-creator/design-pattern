package Builder;

public class Main {
    public static void main(String[] args) {
        // Gaming PC
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);

        director.constructComputer();
        Computer gamingPC = director.getComputer();

        System.out.println("Gaming Computer:");
        System.out.println(gamingPC);

        System.out.println("----------------------");

        // Office PC
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director = new ComputerDirector(officeBuilder);

        director.constructComputer();
        Computer officePC = director.getComputer();

        System.out.println("Office Computer:");
        System.out.println(officePC);
    }
}