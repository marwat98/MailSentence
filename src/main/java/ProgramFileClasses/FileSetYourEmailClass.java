package ProgramFileClasses;

import AbstractClasses.FileManager;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;


public class FileSetYourEmailClass extends FileManager {
    protected EmailValidator emailValidator = EmailValidator.getInstance();

    public FileSetYourEmailClass(File fileName) {
        super(fileName);
    }

    @Override
    public boolean writeEmailToFile(String text) {
        if(text == null || text.isBlank()){
            return false;
        }
        if (!emailValidator.isValid(text)){
            return false;
        }
        try{
            saveToFile(text);
        } catch(IOException e){
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void saveToFile(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(text);
        }
    }

    @Override
    public Set<String> showEmails() {
        Set<String> lines = new LinkedHashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return lines;
    }
}
