package ProgramFileClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class FileOpenAIClass extends FileManagerClass {
    public FileOpenAIClass(File fileName) {
        super(fileName);
    }

    @Override
    public boolean writeToFile(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Don't find file: " + e.getMessage());
        }
        return true;
    }

    @Override
    public Set<String> showEmails() {
        return super.showEmails();
    }
}

