package Observer;

public class WindowDisplay implements WeatherObserver {
    private String name;

    public WindowDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " (Window): Looks like it's " + temperature + "°C outside!");
    }
}
