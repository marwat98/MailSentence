package JavaFXClass;

import AbstractClass.FileManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

public class FileClass extends FileManager {
    public FileClass(File fileName) {
        super(fileName);
    }

    @Override
    public void writeEmailInFile(String text) {

    }

    @Override
    public void showEmails() {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
}
