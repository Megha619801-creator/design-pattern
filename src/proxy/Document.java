package proxy;

public class Document implements DocumentInterface {
    private String id;
    private String creationDate;
    private String content;

    public Document(String id, String creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    // IMPORTANT: Real document should not enforce access control
    public String getContent(User user) {
        return content;
    }
}