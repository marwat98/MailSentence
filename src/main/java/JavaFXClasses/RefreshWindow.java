package JavaFXClasses;

import Interfaces.RefreshWindowInterface;
import ProgramFileClasses.FileManagerClass;
import javafx.scene.control.TextInputControl;

import java.io.File;
import java.util.Set;

/**
 * Class that implements an interface containing a default method
 * responsible for refreshing the contents of a TextField.
 * The method returns the updated TextField instance.
 */
public class RefreshWindow implements RefreshWindowInterface {
    @Override
    public void refreshWindow(TextInputControl inputControl, String path) {
        File myEmailFile = new File(path);
        FileManagerClass file = new FileManagerClass(myEmailFile);

        String content = file.showContent();
        inputControl.setText(content);
    }
}
