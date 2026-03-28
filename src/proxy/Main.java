package proxy;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        // Users
        User alice = new User("alice");
        User bob = new User("bob");

        // Access control setup
        AccessControlService acs = AccessControlService.getInstance();
        acs.allowAccess("doc2", "alice"); // only Alice can access doc2

        // Add documents
        library.addDocument(new Document("doc1", "2026-03-28", "Public content"));
        library.addProtectedDocument("doc2", "2026-03-28", "Secret content");

        try {
            // Public document
            System.out.println(library.getDocument("doc1").getContent(alice));
            System.out.println(library.getDocument("doc1").getContent(bob));

            // Protected document
            System.out.println(library.getDocument("doc2").getContent(alice)); // OK

            System.out.println(library.getDocument("doc2").getContent(bob)); // ERROR

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}