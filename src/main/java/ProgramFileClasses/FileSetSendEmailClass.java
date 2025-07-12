package ProgramFileClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSetSendEmailClass extends FileSetYourEmailClass {
    public FileSetSendEmailClass(File fileName) {
        super(fileName);
    }

    @Override
    public boolean writeEmailToFile(String text) {
        Boolean mainWriteEmail = super.writeEmailToFile(text);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){

           // place loop for emails

        } catch(IOException e){
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
            return false;
        }

        return mainWriteEmail;
    }
}
