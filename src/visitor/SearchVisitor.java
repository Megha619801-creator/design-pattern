package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private String keyword;
    private List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(keyword)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // No action needed
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}