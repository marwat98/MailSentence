package AbstractClass;


import java.io.File;
import java.io.IOException;
import java.sql.Date;

public abstract class FileManager {
    protected File fileName;

    public FileManager(File fileName){
        this.fileName = fileName;
    }

    public abstract void writeEmailInFile(String text);

    public abstract String showEmails();
}
