package FileClass;

import AbstractClass.FileManager;
import javafx.scene.control.Alert;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;


public class FileClass extends FileManager {
    public FileClass(File fileName) {
        super(fileName);
    }

    @Override
    public boolean writeEmailToFile(String text) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if(text == null || text.isBlank()){
            return false;
        }
        if (!emailValidator.isValid(text)){
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(text);
        } catch(IOException e){
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String showEmails() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return "Null data";
    }
}
