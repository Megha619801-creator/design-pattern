package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatMediatorImpl implements ChatMediator {

    private Map<String, ChatController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, String from, String to) {
        ChatController receiver = clients.get(to);
        ChatController sender = clients.get(from);

        if (receiver != null) {
            receiver.receiveMessage(from, message);
        }

        if (sender != null) {
            sender.receiveMessage(from, message); // show in sender's own chat
        }
    }

    public Map<String, ChatController> getClients() {
        return clients;
    }
}