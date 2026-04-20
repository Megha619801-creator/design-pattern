package Mediator;

import javafx.scene.control.*;

public class ChatController {

    private String username;
    private ChatMediator mediator;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> userSelector;
    private Button sendButton;

    public ChatController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUI(TextArea chatArea, TextField messageField,
                      ComboBox<String> userSelector, Button sendButton) {

        this.chatArea = chatArea;
        this.messageField = messageField;
        this.userSelector = userSelector;
        this.sendButton = sendButton;

        sendButton.setOnAction(e -> sendMessage());
    }

    private void sendMessage() {
        String message = messageField.getText();
        String recipient = userSelector.getValue();

        if (message.isEmpty() || recipient == null) return;

        mediator.sendMessage(message, username, recipient);
        messageField.clear();
    }

    public void receiveMessage(String from, String message) {
        chatArea.appendText(from + ": " + message + "\n");
    }
}