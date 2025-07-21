package ProgramFileClasses;

import AbstractClasses.FileManager;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;


public class FileManagerClass extends FileManager {
    protected EmailValidator emailValidator = EmailValidator.getInstance();

    public FileManagerClass(File fileName) {
        super(fileName);
    }

    /**
     * method writing text to file
     * @param text argument takes the text of input field
     * @return true if writing to file ending correct and false if is error
     */
    @Override
    public boolean writeToFile(String text) {
        if(text == null || text.isEmpty()){
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        if (!emailValidator.isValid(text)){
            throw new IllegalArgumentException("Text must be email");
        }
        try{
            saveToFile(text);
        } catch(IOException e){
            throw new RuntimeException("Don't find file: " +  e.getMessage());
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
            throw new RuntimeException("File doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }
        return lines;
    }
}
