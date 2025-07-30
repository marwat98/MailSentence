package FileManagerClasses;

import org.apache.commons.validator.routines.EmailValidator;

import java.io.*;
import java.nio.file.Path;

public class FileManagerSendEmailClass extends FileManagerClass {
    protected EmailValidator emailValidator = EmailValidator.getInstance();

    public FileManagerSendEmailClass(Path fileName) {
        super(fileName);
    }

    @Override
    public boolean writeToFile(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        if (!emailValidator.isValid(text)) {
            throw new IllegalArgumentException("Text must be email");
        }
        try {
            saveToFile(text);
        } catch (IOException e) {
            throw new RuntimeException("Don't find file: " +  e.getMessage());
        }
        return true;
    }

    @Override
    public void saveToFile(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(fileName), true))) {
            writer.write(text);
            writer.write(", ");
        }
    }


    @Override
    public String showContent() {
        return super.showContent();
    }
}

