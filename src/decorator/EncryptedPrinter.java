package decorator;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer decoratedPrinter) {
        super(decoratedPrinter);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        decoratedPrinter.print(encryptedMessage);
    }

    private String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            result.append((char) (c + 3));  // simple Caesar shift
        }

        return result.toString();
    }
}