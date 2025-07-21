package Interfaces;

import ProgramFileClasses.FileManagerClass;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.Set;

public interface RefreshWindowInterface {

    default TextField refreshWindow(TextField textField,String path){
        File myEmailFile = new File(path);
        FileManagerClass file = new FileManagerClass(myEmailFile);
        Set<String> showContent = file.showEmails();
        for (String data: showContent){
            textField.setText(data);
        }
        return textField;
    }
}
