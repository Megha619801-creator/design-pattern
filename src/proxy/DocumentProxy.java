package proxy;

public class DocumentProxy implements DocumentInterface {

    private Document realDocument;

    public DocumentProxy(Document document) {
        this.realDocument = document;
    }

    public String getId() {
        return realDocument.getId();
    }

    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    public String getContent(User user) throws AccessDeniedException {
        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException(
                    "Access denied for user: " + user.getUsername()
            );
        }
    }
}