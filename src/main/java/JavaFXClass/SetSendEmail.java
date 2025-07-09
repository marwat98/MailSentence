package JavaFXClass;

import Interfaces.WindowViewInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SetSendEmail extends SetYourEmail {

    @Override
    public HBox title(HBox hbox, String labelText) {
        return super.title(hbox, labelText);
    }

    @Override
    public HBox topPartOfWindow(HBox hbox) {
        HBox baseBox = super.topPartOfWindow(hbox);

        email.setPrefSize(480,20);

        ButtonManager buttonManager = new ButtonManager();
        Button addEmail = buttonManager.setButtonSize("Add Email", 100,20);
        addEmail.setOnAction(e ->{

        });

        HBox.setMargin(addEmail,new Insets(100,0,0,10));
        hbox.getChildren().add(addEmail);

        return baseBox;
    }

}
