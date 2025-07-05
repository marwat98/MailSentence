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
    public void writeEmailToFile(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        EmailValidator emailValidator = EmailValidator.getInstance();
        if(text.equals("") || text.isEmpty()){
            alert.setTitle("Empty Field Error");
            alert.setHeaderText(null);
            alert.setContentText("Field can't be empty");
            alert.showAndWait();
            return;
        }
        if(!emailValidator.isValid(text)){
            alert.setTitle("Error email address");
            alert.setHeaderText(null);
            alert.setContentText("This text isn't email address");
            alert.showAndWait();
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(text);
            alert.setTitle("Succes");
            alert.setHeaderText(null);
            alert.setContentText("You save email: " + text);
            alert.showAndWait();
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
        }
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
