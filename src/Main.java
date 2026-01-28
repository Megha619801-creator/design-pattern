import asciiui.*;

public class Main {
    public static void main(String[] args) {

        UIFactory factory = new AFactory(); // Change to BFactory to switch style

        Button button = factory.createButton("Submit");
        TextField textField = factory.createTextField("Username");
        Checkbox checkbox = factory.createCheckbox("Accept Terms");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\n-- After text update --");

        button.setText("Login");
        textField.setText("Email");
        checkbox.setText("Subscribe");

        button.display();
        textField.display();
        checkbox.display();
    }
}

