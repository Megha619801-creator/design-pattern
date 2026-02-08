package Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        PhoneDisplay phone = new PhoneDisplay("Alice");
        TVDisplay tv = new TVDisplay("LivingRoom");
        WindowDisplay window = new WindowDisplay("Kitchen");

        // Register observers
        station.registerObserver(phone);
        station.registerObserver(tv);
        station.registerObserver(window);

        // Start weather station thread
        station.start();

        try {
            // Let simulation run for 15 seconds
            Thread.sleep(15000);

            System.out.println("\n--- Removing TV observer ---\n");
            station.removeObserver(tv);

            // Let it run 15 more seconds
            Thread.sleep(15000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSimulation finished.");
        System.exit(0);
    }
}
