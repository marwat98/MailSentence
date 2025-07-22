package AbstractClasses;


import java.io.File;
import java.io.IOException;
import java.util.Set;


public abstract class FileManager {
    protected File fileName;

    public FileManager(File fileName){
        this.fileName = fileName;
    }

    public abstract boolean writeToFile(String text);

    public abstract void saveToFile(String text) throws IOException;

    public abstract String showContent();
}
