package rpg.map;

import java.util.Random;
import rpg.tile.*;

public class CityMap extends Map {

    @Override
    protected Tile createTile() {
        int choice = new Random().nextInt(3);
        return switch (choice) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            default -> new BuildingTile();
        };
    }
}
