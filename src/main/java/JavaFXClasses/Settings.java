package JavaFXClasses;

import Interfaces.WindowViewInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Settings  implements WindowViewInterface {
    PasswordField apiFieldKey = new PasswordField();

    @Override
    public HBox title(HBox hbox, String labelText) {
        Label titleSettings = new Label(labelText);
        titleSettings.setFont(Font.font(20));

        hbox.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(titleSettings, new Insets(25, 0, 0, 0));
        hbox.getChildren().addAll(titleSettings);

        return hbox;
    }

    @Override
    public VBox inputPartOfWindow(VBox vbox) {
        // Label for Open AI Field Key
        Label apiOpenKeyLabel = new Label("OpenAI Key");
        apiOpenKeyLabel.setFont(Font.font(15));
        apiFieldKey.setPrefSize(530,20);


        HBox apiHBox = new HBox();
        apiHBox.setAlignment(Pos.TOP_LEFT);
        apiHBox.getChildren().addAll(apiOpenKeyLabel,apiFieldKey);
        HBox.setMargin(apiOpenKeyLabel,new Insets(10,0,0,0));
        HBox.setMargin(apiFieldKey,new Insets(10,0,0,0));

        vbox.getChildren().addAll(apiHBox);

        return vbox;


    }

    @Override
    public VBox separator(VBox vboxSeparator) {
        return null;
    }

    @Override
    public HBox buttonPartOfWindow(HBox vbox) {
        return null;
    }
}
