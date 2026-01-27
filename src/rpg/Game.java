package rpg;

import rpg.map.*;

public class Game {

    public static Map createMap(String type) {
        return type.equalsIgnoreCase("city")
                ? new CityMap()
                : new WildernessMap();
    }

    public static void main(String[] args) {
        Map map = createMap("city"); // or "wilderness"
        map.display();
    }
}
