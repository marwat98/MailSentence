package AbstractClasses;


import java.io.File;
import java.io.IOException;
import java.util.List;


public abstract class FileManager {
    protected File fileName;

    public FileManager(File fileName){
        this.fileName = fileName;
    }

    public abstract boolean writeEmailToFile(String text);

    public abstract void saveToFile(String text , List<String> emails) throws IOException;

    public abstract String showEmails();
}
