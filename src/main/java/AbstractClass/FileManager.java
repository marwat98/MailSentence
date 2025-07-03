package AbstractClass;


import java.io.File;


public abstract class FileManager {
    protected File fileName;

    public FileManager(File fileName){
        this.fileName = fileName;
    }

    public abstract void writeEmailInFile(String text);

    public abstract String showEmails();
}
