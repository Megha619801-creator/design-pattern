package design;

public class MoveCursorLeftCommand implements Command {

    private PixelGrid grid;

    public MoveCursorLeftCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveLeft();
    }
}