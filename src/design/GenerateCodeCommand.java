package design;

public class GenerateCodeCommand implements Command {

    private PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        System.out.println(grid.generateCode());
    }
}