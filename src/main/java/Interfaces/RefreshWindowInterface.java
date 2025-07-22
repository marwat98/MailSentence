package Interfaces;

import ProgramFileClasses.FileManagerClass;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

import java.io.File;
import java.util.Set;

public interface RefreshWindowInterface {
    void refreshWindow(TextInputControl inputControl, String path);
}
