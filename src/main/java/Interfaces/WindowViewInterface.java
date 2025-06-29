package Interfaces;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public interface WindowViewInterface {
    HBox topPartOfWindow(HBox hbox);
    VBox middlePartOfWindow(VBox vbox);
    HBox buttonPartOfWindow(HBox vbox);
}
