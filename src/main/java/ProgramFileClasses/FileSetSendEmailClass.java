package ProgramFileClasses;

import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.util.*;

public class FileSetSendEmailClass extends FileSetYourEmailClass {
    protected EmailValidator emailValidator = EmailValidator.getInstance();

    public FileSetSendEmailClass(File fileName) {
        super(fileName);
    }

    @Override
    public boolean writeEmailToFile(String text) {
        if (text == null || text.isBlank()) {
            return false;
        }
        if (!emailValidator.isValid(text)) {
            return false;
        }
        try {
            saveToFile(text);
        } catch (IOException e) {
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void saveToFile(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text);
            writer.write(", ");
        }
    }


    @Override
    public Set<String> showEmails() {
        return super.showEmails();
    }
}

