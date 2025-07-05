package AbstractClass;


import java.io.File;


public abstract class FileManager {
    protected File fileName;

    public FileManager(File fileName){
        this.fileName = fileName;
    }

    public abstract void writeEmailToFile(String text);

    public abstract String showEmails();
}
