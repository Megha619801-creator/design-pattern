package rpg.map;

import rpg.tile.Tile;

public abstract class Map {
    protected int rows = 5;
    protected int cols = 5;
    protected Tile[][] tiles;

    public Map() {
        tiles = new Tile[rows][cols];
        generateMap();
    }

    protected abstract Tile createTile(); // Factory Method

    private void generateMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
