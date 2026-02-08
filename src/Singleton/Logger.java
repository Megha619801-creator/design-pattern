package Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    // Single instance (Singleton)
    private static Logger instance;

    private BufferedWriter writer;
    private String fileName;

    // Private constructor prevents direct creation
    private Logger() {
        fileName = "default_log.txt";
        openFile();
    }

    // Global access point
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Open file for writing
    private void openFile() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }

    // Change log file
    public void setFileName(String newFileName) {
        close(); // close current file
        this.fileName = newFileName;
        openFile(); // open new file
    }

    // Write a message to the file
    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Close the file safely
    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing file: " + e.getMessage());
        }
    }
}
