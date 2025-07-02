package JavaFXClass;

import AbstractClass.FileManager;

import java.io.*;


public class FileClass extends FileManager {
    public FileClass(File fileName) {
        super(fileName);
    }

    @Override
    public void writeEmailInFile(String text) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                writer.write(text);
            } catch (FileNotFoundException e) {
                System.err.println("File doesn't exist: " + e.getMessage());
            } catch(IOException e){
                System.out.println("Error: Save text in file isn't possible " + e.getMessage());
            }
    }


    @Override
    public String showEmails() {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return showEmails();
    }
}
