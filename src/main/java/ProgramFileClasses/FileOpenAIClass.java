package ProgramFileClasses;

import java.io.*;
import java.util.Scanner;
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
    public String showContent() {
        return super.showContent();
    }
    /**
     * method read API Key of file
     * @param apiFile allow implementing File to method
     * @return String text of file
     */
    public String readFile(File apiFile){
        try(Scanner readFile = new Scanner(apiFile)){
            if(readFile.hasNextLine()){
                return readFile.nextLine().trim();
            } else {
                throw new IllegalStateException("File haven't text");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesn't exist" + e.getMessage());
        }
    }
}

