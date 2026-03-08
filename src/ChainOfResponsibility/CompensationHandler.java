package ChainOfResponsibility;

public class CompensationHandler extends FeedbackHandler {

    @Override
    public void handleMessage(Message message) {

        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("Compensation claim received from "
                    + message.getSenderEmail());

            System.out.println("Claim is being reviewed.");
        } else {
            super.handleMessage(message);
        }
    }
}