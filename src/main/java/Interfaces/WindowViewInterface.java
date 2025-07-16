package Interfaces;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public interface WindowViewInterface {
    HBox title(HBox hbox,String labelText);
    VBox inputPartOfWindow(VBox vbox);
    VBox separator(VBox vboxSeparator);
    HBox buttonPartOfWindow(HBox vbox);
}
