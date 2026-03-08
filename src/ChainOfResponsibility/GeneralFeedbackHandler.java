package ChainOfResponsibility;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    public void handleMessage(Message message) {

        if (message.getType() == MessageType.GENERAL_FEEDBACK) {

            System.out.println("General feedback received:");
            System.out.println(message.getContent());

            System.out.println("Thanking customer for feedback.");

        } else {
            super.handleMessage(message);
        }
    }
}