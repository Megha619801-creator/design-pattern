package design;

public class PixelGrid {

    private final boolean[][] pixels = new boolean[8][8];

    private int cursorRow = 0;
    private int cursorCol = 0;

    public boolean[][] getPixels() {
        return pixels;
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void moveUp() {
        if (cursorRow > 0) cursorRow--;
    }

    public void moveDown() {
        if (cursorRow < 7) cursorRow++;
    }

    public void moveLeft() {
        if (cursorCol > 0) cursorCol--;
    }

    public void moveRight() {
        if (cursorCol < 7) cursorCol++;
    }

    public void togglePixel() {
        pixels[cursorRow][cursorCol] =
                !pixels[cursorRow][cursorCol];
    }

    public String generateCode() {
        StringBuilder sb = new StringBuilder();

        sb.append("int[][] pixelArt = {\n");

        for (int r = 0; r < 8; r++) {
            sb.append("    {");

            for (int c = 0; c < 8; c++) {
                sb.append(pixels[r][c] ? 1 : 0);

                if (c < 7) sb.append(", ");
            }

            sb.append("}");

            if (r < 7) sb.append(",");

            sb.append("\n");
        }

        sb.append("};");

        return sb.toString();
    }
}
