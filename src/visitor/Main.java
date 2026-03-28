package visitor;

public class Main {
    public static void main(String[] args) {

        // Create files
        File file1 = new File("notes.txt", 2.5);
        File file2 = new File("photo.jpg", 5.0);
        File file3 = new File("report.pdf", 3.0);
        File file4 = new File("todo.txt", 1.0);

        // Create directories
        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory images = new Directory("images");

        // Build structure
        docs.add(file1);
        docs.add(file3);
        docs.add(file4);

        images.add(file2);

        root.add(docs);
        root.add(images);

        // ✅ Size calculation
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        // ✅ Search
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("Found .txt files:");
        for (File f : searchVisitor.getFoundFiles()) {
            System.out.println("- " + f.getName());
        }
    }
}