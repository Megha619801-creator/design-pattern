package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {

    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;
    private Random random = new Random();

    public WeatherStation() {
        // Initial random temperature between MIN and MAX
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
        System.out.println("Initial temperature: " + temperature + "°C");
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        int newTemp = temperature + change;

        if (newTemp >= MIN_TEMP && newTemp <= MAX_TEMP) {
            temperature = newTemp;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Wait 1–5 seconds
                Thread.sleep((random.nextInt(5) + 1) * 1000);

                updateTemperature();
                System.out.println("\nWeatherStation: Temperature updated to " + temperature + "°C");
                notifyObservers();

            } catch (InterruptedException e) {
                System.out.println("Weather station stopped.");
                break;
            }
        }
    }
}
