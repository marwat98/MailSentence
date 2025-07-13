package ProgramFileClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSetSendEmailClass extends BaseFileManager {
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
           saveToFile(text);
        } catch(IOException e){
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void saveToFile(String text) throws IOException {
        String allData[] = new String[]{text};
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String data : allData) {
                writer.write(data);
                writer.newLine();
            }
        }
    }

    @Override
    public String showEmails() {
        return super.showEmails();
    }
}
