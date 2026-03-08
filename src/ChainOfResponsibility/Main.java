package ChainOfResponsibility;

public class Main {

    public static void main(String[] args) {

        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler development = new DevelopmentSuggestionHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        // Build the chain
        compensation.setNextHandler(contact);
        contact.setNextHandler(development);
        development.setNextHandler(general);

        // Create messages
        Message m1 = new Message(
                MessageType.COMPENSATION,
                "My order arrived damaged.",
                "customer1@email.com");

        Message m2 = new Message(
                MessageType.CONTACT_REQUEST,
                "Please call me about my order.",
                "customer2@email.com");

        Message m3 = new Message(
                MessageType.DEVELOPMENT_SUGGESTION,
                "Add dark mode to the app.",
                "customer3@email.com");

        Message m4 = new Message(
                MessageType.GENERAL_FEEDBACK,
                "Great service!",
                "customer4@email.com");

        // Send messages to chain
        compensation.handleMessage(m1);
        compensation.handleMessage(m2);
        compensation.handleMessage(m3);
        compensation.handleMessage(m4);
    }
}