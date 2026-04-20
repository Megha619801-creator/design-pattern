package Mediator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediatorImpl mediator = new ChatMediatorImpl();

        createClientWindow("Alice", mediator);
        createClientWindow("Bob", mediator);
        createClientWindow("Charlie", mediator);
    }

    private void createClientWindow(String username, ChatMediatorImpl mediator) {
        Stage stage = new Stage();
        stage.setTitle(username);

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField messageField = new TextField();

        ComboBox<String> userSelector = new ComboBox<>();
        Button sendButton = new Button("Send");

        ChatController controller = new ChatController(username, mediator);

        // Populate recipients (after registering)
        userSelector.getItems().addAll(mediator.getClients().keySet());

        controller.setUI(chatArea, messageField, userSelector, sendButton);

        VBox layout = new VBox(10, chatArea, messageField, userSelector, sendButton);

        stage.setScene(new Scene(layout, 300, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}