package FileWriterClass;

import AbstractClass.FileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterClass extends FileWriter {

    public FileWriterClass(File fileName) {
        super(fileName);
    }
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
}

