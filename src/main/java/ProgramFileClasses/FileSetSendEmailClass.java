package ProgramFileClasses;

import AbstractClasses.FileManager;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSetSendEmailClass extends FileManager {
    protected EmailValidator emailValidator = EmailValidator.getInstance();

    public FileSetSendEmailClass(File fileName) {
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
            List<String> data = Arrays.asList(text);
            saveToFile(null,data);
        } catch(IOException e){
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void saveToFile(String text, List<String> emails) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (int i = 0; i < emails.size(); i++) {
                writer.write(emails.get(i));

                // dodaj przecinek tylko jeśli to nie ostatni element
                if (i < emails.size() - 1) {
                    writer.write(", ");
                }

            }
        }
    }



    @Override
    public String showEmails() {
        return null;
    }
    public List<String> showSendEmails(){
        List<String> lines = new ArrayList<>();
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

