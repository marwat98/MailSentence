package JavaFXClass;

import AbstractClass.FileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

public class FileClass extends FileManager {
    public FileClass(File fileName) {
        super(fileName);
    }

    @Override
    public void writeEmailInFile(String text) {

    }

    @Override
    public void showEmails(int id, String email,Date date) {
        File file = super.fileName;
        try {
            List<String> line = Files.readAllLines(Paths.get(file.toString()));
            String[] parts = line.toArray(new String[0]);
            for (int i = 0; i <= line.hashCode(); i++) {
                id = Integer.parseInt(parts[0].trim());
                email = parts[1].trim();
                date = Date.valueOf(parts[2].trim());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
