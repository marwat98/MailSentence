package ProgramFileClasses;

import AbstractClasses.FileManager;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.nio.file.Path;


public class FileManagerClass extends FileManager {
    protected EmailValidator emailValidator = EmailValidator.getInstance();

    public FileManagerClass(Path fileName) {
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(fileName)))){
            writer.write(text);
        }
    }

    @Override
    public String showContent() {
        StringBuilder multiplyLines = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(fileName)))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                multiplyLines.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }
        return multiplyLines.toString();
    }
}
