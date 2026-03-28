package visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private double totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // Nothing needed here for size
    }

    public double getTotalSize() {
        return totalSize;
    }
}
