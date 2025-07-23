package JavaFXClasses;

import Interfaces.WindowViewInterface;
import MenuProgram.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Settings extends SetEmail implements WindowViewInterface {
    PasswordField apiFieldKey = new PasswordField();
    PasswordField tokenOrPasswordPostOfficeField = new PasswordField();
    ObservableList<String> postOfficess = FXCollections.observableArrayList("Gmail","Outlook","Wp","Onet");
    ComboBox<String> postOfficeBox = new ComboBox<>(postOfficess);
    TextField hostAdressField = new TextField();

    @Override
    public HBox title(HBox hbox, String labelText) {
        Label titleSettings = new Label(labelText);
        titleSettings.setFont(Font.font(15));

        hbox.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(titleSettings, new Insets(25,0,0,0));
        hbox.getChildren().addAll(titleSettings);

        return hbox;
    }

    @Override
    public VBox inputPartOfWindow(VBox vbox) {

        // Label and textfield for Key AI
        Label apiOpenKeyLabel = new Label("Key AI");
        apiOpenKeyLabel.setFont(Font.font(15));
        apiFieldKey.setPrefSize(530,20);

        HBox apiHBox = new HBox();
        apiHBox.setAlignment(Pos.TOP_LEFT);
        apiHBox.getChildren().addAll(apiOpenKeyLabel,apiFieldKey);
        HBox.setMargin(apiOpenKeyLabel,new Insets(20,62,0,10));
        HBox.setMargin(apiFieldKey,new Insets(20,0,0,10));

        // Label and combox for change post office
        Label checkPostOfficeLabel = new Label("Post Office");
        checkPostOfficeLabel.setFont(Font.font(15));
        postOfficeBox.setPrefSize(100,20);
        postOfficeBox.setValue("Gmail");

        HBox postOfficeHBox = new HBox();
        postOfficeHBox.setAlignment(Pos.TOP_LEFT);
        postOfficeHBox.getChildren().addAll(checkPostOfficeLabel, postOfficeBox);
        HBox.setMargin(checkPostOfficeLabel,new Insets(20,32,0,10));
        HBox.setMargin(postOfficeBox,new Insets(20,0,0,10));

        //Label and TextField for host adress
        Label hostAdressLabel = new Label("Host Adress");
        hostAdressLabel.setFont(Font.font(15));
        hostAdressField.setPrefSize(530,20);

        HBox hostAdressHBox = new HBox();
        hostAdressHBox.setAlignment(Pos.TOP_LEFT);
        hostAdressHBox.getChildren().addAll(hostAdressLabel,hostAdressField);
        HBox.setMargin(hostAdressLabel,new Insets(20,25,0,10));
        HBox.setMargin(hostAdressField,new Insets(20,0,0,10));

        //Label and PasswordField for email token or password
        Label tokenOrPostOfficePasswordLabel = new Label("Post Password");
        tokenOrPostOfficePasswordLabel.setFont(Font.font(15));
        tokenOrPasswordPostOfficeField.setPrefSize(530,20);

        HBox tokenOrPasswordPostOfficeHBox = new HBox();
        tokenOrPasswordPostOfficeHBox.setAlignment(Pos.TOP_LEFT);
        tokenOrPasswordPostOfficeHBox.getChildren().addAll(tokenOrPostOfficePasswordLabel,tokenOrPasswordPostOfficeField);
        HBox.setMargin(tokenOrPostOfficePasswordLabel,new Insets(20,10,0,10));
        HBox.setMargin(tokenOrPasswordPostOfficeField,new Insets(20,0,0,10));

        vbox.getChildren().addAll(apiHBox,postOfficeHBox,hostAdressHBox,tokenOrPasswordPostOfficeHBox);

        return vbox;


    }

    @Override
    public VBox separator(VBox vboxSeparator) {
        separator.setPrefWidth(200);

        VBox.setMargin(separator, new Insets(110, 0, 0, 0));
        vboxSeparator.getChildren().addAll(separator);

        return vboxSeparator;
    }

    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        Button cancel = button.setButtonSize("Cancel",100, 20);
        Button save = button.setButtonSize("Save",100, 20);

        // Action returning to menu window
        cancel.setOnAction( e->{
            Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
            currentlyWindow.close();
            try {
                new Menu().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Action which save settings
        save.setOnAction(e->{

        });

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(10,0,12,35));
        HBox.setMargin(save,new Insets(10,10,12,10));
        hbox.getChildren().addAll(cancel, save);

        return hbox;
    }
}
