package ChainOfResponsibility;

public abstract class FeedbackHandler {

    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleMessage(Message message) {

        if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }

    }
}