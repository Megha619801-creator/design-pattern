package design;

public class MoveCursorRightCommand implements Command {

    private PixelGrid grid;

    public MoveCursorRightCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveRight();
    }
}