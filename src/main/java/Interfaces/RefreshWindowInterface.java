package Interfaces;

import ProgramFileClasses.FileSetYourEmailClass;
import javafx.scene.control.TextField;

import java.io.File;

public interface RefreshWindowInterface {

    default TextField refreshWindow(TextField textField){
        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
        FileSetYourEmailClass file = new FileSetYourEmailClass(myEmailFile);
        String showContent = file.showEmails();
        textField.setText(showContent);
        return textField;
    }
}
