package Interfaces;

import ProgramFileClasses.FileSetYourEmailClass;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.Set;

public interface RefreshWindowInterface {

    default TextField refreshWindow(TextField textField){
        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
        FileSetYourEmailClass file = new FileSetYourEmailClass(myEmailFile);
        Set<String> showContent = file.showEmails();
        for (String data: showContent){
            textField.setText(data);
        }
        return textField;
    }
}
