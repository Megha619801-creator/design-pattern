package ChainOfResponsibility;

public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    public void handleMessage(Message message) {

        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {

            System.out.println("Development suggestion received:");
            System.out.println(message.getContent());

            System.out.println("Logged for product team.");

        } else {
            super.handleMessage(message);
        }
    }
}