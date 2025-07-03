package Interfaces;

import JavaFXClass.FileClass;
import javafx.scene.control.TextField;

import java.io.File;

public interface RefreshWindowInterface {

    default TextField refreshWindow(TextField textField){
        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
        FileClass file = new FileClass(myEmailFile);
        String showContent = file.showEmails();
        textField.setText(showContent);
        return textField;
    }
}
