package proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, DocumentInterface> documents;

    public Library() {
        documents = new HashMap<>();
    }

    // Add unprotected document
    public void addDocument(Document document) {
        documents.put(document.getId(), document);
    }

    // Factory method for protected document
    public void addProtectedDocument(String id, String date, String content) {
        Document doc = new Document(id, date, content);
        DocumentProxy proxy = new DocumentProxy(doc);
        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}