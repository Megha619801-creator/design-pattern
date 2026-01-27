package rpg.map;

import java.util.Random;
import rpg.tile.*;

public class WildernessMap extends Map {

    @Override
    protected Tile createTile() {
        int choice = new Random().nextInt(3);
        return switch (choice) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }
}
