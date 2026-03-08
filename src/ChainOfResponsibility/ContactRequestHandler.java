package ChainOfResponsibility;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    public void handleMessage(Message message) {

        if (message.getType() == MessageType.CONTACT_REQUEST) {

            System.out.println("Contact request from "
                    + message.getSenderEmail());

            System.out.println("Forwarding to customer service.");

        } else {
            super.handleMessage(message);
        }
    }
}