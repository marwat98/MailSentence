package JavaFXClass;

import Interfaces.WindowViewInterface;
import MainProgramFile.Main;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SetYourEmail implements WindowViewInterface {


    public HBox title(HBox hbox){
        Label writeYourEmail = new Label("Write your email");
        writeYourEmail.setFont(Font.font(15));

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(writeYourEmail,new Insets(20,0,0,85));
        hbox.getChildren().addAll(writeYourEmail);

        return hbox;
    }

    /**
     * method builds and return top part of the email settings view
     * @param hbox to which UI components will be added
     * @return hbox containing (Label , TextField , Button)
     */
    @Override
    public HBox topPartOfWindow(HBox hbox ) {
        Label label = new Label("Email");
        label.setFont(Font.font(15));

        TextField email = new TextField();
        email.setPrefSize(575,20);

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(label,new Insets(50,0,0,15));
        HBox.setMargin(email,new Insets(50,0,0,25));
        hbox.getChildren().addAll(label,email);

        return hbox;
    }

    /**
     * method builds and return middle part of the email settings view
     * @param hbox to which UI components will be added
     * @return hbox containing Label and TextField with file content
     */
    @Override
    public HBox middlePartOfWindow(HBox hbox) {
        Label contain = new Label("Contain");
        contain.setFont(Font.font(15));

        TextField readText = new TextField();
        readText.setPrefSize(575,200);

        hbox.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(contain,new Insets(180,20,0,-20));
        HBox.setMargin(readText,new Insets(100,0,0,0));
        hbox.getChildren().addAll(contain,readText);

        return hbox;
    }

    /**
     * method builds and return button part of the email settings view
     * @param hbox to UI buttons
     * @return hbox containg buttons
     */
    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        ButtonManager button = new ButtonManager();
        Button cancel = button.setButtonSize("Cancel",100, 20);
        Button edit = button.setButtonSize("Save",100, 20);

        cancel.setOnAction( e->{
            Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
            currentlyWindow.close();

            try {
                new Main().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        edit.setOnAction(e->{

        });

        hbox.setAlignment(Pos.BOTTOM_LEFT);
        HBox.setMargin(cancel,new Insets(0,0,3,35));
        HBox.setMargin(edit,new Insets(0,0,3,10));
        hbox.getChildren().addAll(cancel,edit);

        return hbox;
    }
}
