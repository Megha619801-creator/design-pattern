package design;

public class MoveCursorDownCommand implements Command {

    private PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveDown();
    }
}