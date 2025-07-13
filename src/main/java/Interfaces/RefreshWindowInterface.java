package Interfaces;

import ProgramFileClasses.BaseFileManager;
import javafx.scene.control.TextField;

import java.io.File;

public interface RefreshWindowInterface {

    default TextField refreshWindow(TextField textField){
        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
        BaseFileManager file = new BaseFileManager(myEmailFile);
        String showContent = file.showEmails();
        textField.setText(showContent);
        return textField;
    }
}
