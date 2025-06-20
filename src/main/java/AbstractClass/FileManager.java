package AbstractClass;


import java.io.File;
import java.io.IOException;

public abstract class FileManager {
    protected File fileName;

    public FileManager(File fileName){
        this.fileName = fileName;
    }

    public abstract void writeEmailInFile(String text);

    public abstract void showEmails() throws IOException;
}
