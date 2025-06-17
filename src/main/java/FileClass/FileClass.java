package FileClass;

import AbstractClass.FileManager;

import java.io.*;

public class FileClass extends FileManager {

    public FileClass(File fileName) {
        super(fileName);
    }
    // method which write email to file
    @Override
    public void writeEmailInFile(String text){
        try{
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName));
            writer.write(text);
            writer.close();
        } catch(IOException e){
            System.out.println("Error: Save text in file isn't possible " + e.getMessage());
        }
    }
    //method which showing email of file
    @Override
    public void showEmails() throws IOException {
        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String line = bufferReader.readLine();
            while (line != null) {
                builder.append(line);
                line = bufferReader.readLine();
            }
            String everything = builder.toString();
            System.out.println(everything);
            bufferReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

