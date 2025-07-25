package JavaFXClasses;

import Interfaces.RefreshWindowInterface;
import ProgramFileClasses.FileManagerClass;
import javafx.scene.control.TextInputControl;

import java.io.File;
import java.nio.file.Path;
import java.util.Set;

/**
 * Class that implements an interface containing a default method
 * responsible for refreshing the contents of a TextField.
 * The method returns the updated TextField instance.
 */
public class RefreshWindow implements RefreshWindowInterface {
    @Override
    public void refreshWindow(TextInputControl inputControl, Path path) {
        File myEmailFile = new File(String.valueOf(path));
        FileManagerClass file = new FileManagerClass(myEmailFile.toPath());

        String content = file.showContent();
        inputControl.setText(content);
    }
}
