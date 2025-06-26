package Interfaces;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public interface SetYourEmailWindowInterface {
    HBox topPartOfSetYourEmailWindow(HBox hbox);
    VBox middlePartOfSetYourEmailWindow(VBox vbox);
    VBox buttonPartOfSetYourEmailWindow(Button cancel, Button save);
}
