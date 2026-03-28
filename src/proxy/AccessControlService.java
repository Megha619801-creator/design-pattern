package proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {

    private static AccessControlService instance = new AccessControlService();

    private Map<String, Set<String>> permissions;

    private AccessControlService() {
        permissions = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        return instance;
    }

    public void allowAccess(String documentId, String username) {
        permissions.putIfAbsent(documentId, new HashSet<>());
        permissions.get(documentId).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.containsKey(documentId) &&
                permissions.get(documentId).contains(username);
    }
}
