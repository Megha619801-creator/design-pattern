package Mediator;
public interface ChatMediator {
    void sendMessage(String message, String from, String to);
    void registerClient(ChatController client);
}