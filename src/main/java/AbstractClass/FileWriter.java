package AbstractClass;


import java.io.File;

public abstract class FileWriter {
    protected File fileName;

    public FileWriter(File fileName){
        this.fileName = fileName;
    }

    // method which write email to file
    public abstract void writeEmailInFile(String text);
}
