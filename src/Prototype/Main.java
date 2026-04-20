package Prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Recommendation> recommendations = new HashMap<>();

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. Create new recommendation");
            System.out.println("2. View recommendations");
            System.out.println("3. Clone recommendation");
            System.out.println("4. Modify recommendation");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Target audience: ");
                    String audience = scanner.nextLine();

                    Recommendation rec = new Recommendation(audience);

                    while (true) {
                        System.out.print("Add a book? (y/n): ");
                        if (!scanner.nextLine().equalsIgnoreCase("y")) break;

                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Author: ");
                        String author = scanner.nextLine();

                        rec.addBook(new Book(author, title));
                    }

                    recommendations.put(name, rec);
                    break;

                case "2":
                    for (String key : recommendations.keySet()) {
                        System.out.println("\n[" + key + "]");
                        recommendations.get(key).display();
                    }
                    break;

                case "3":
                    System.out.print("Clone which recommendation?: ");
                    String source = scanner.nextLine();

                    if (recommendations.containsKey(source)) {
                        System.out.print("New name: ");
                        String newName = scanner.nextLine();

                        Recommendation cloned = recommendations.get(source).clone();

                        System.out.print("New audience (or press enter to keep): ");
                        String newAudience = scanner.nextLine();
                        if (!newAudience.isEmpty()) {
                            cloned.setTargetAudience(newAudience);
                        }

                        recommendations.put(newName, cloned);
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case "4":
                    System.out.print("Which recommendation?: ");
                    String key = scanner.nextLine();

                    if (recommendations.containsKey(key)) {
                        Recommendation r = recommendations.get(key);

                        System.out.println("1. Add book");
                        System.out.println("2. Remove book");

                        String sub = scanner.nextLine();

                        if (sub.equals("1")) {
                            System.out.print("Title: ");
                            String title = scanner.nextLine();

                            System.out.print("Author: ");
                            String author = scanner.nextLine();

                            r.addBook(new Book(author, title));

                        } else if (sub.equals("2")) {
                            System.out.print("Title to remove: ");
                            String title = scanner.nextLine();

                            r.removeBook(title);
                        }
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}