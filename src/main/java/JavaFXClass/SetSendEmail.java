package JavaFXClass;

import MainProgramFile.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SetSendEmail extends SetYourEmail {
    ButtonManager button = new ButtonManager();

    @Override
    public HBox title(HBox hbox, String labelText) {
        return super.title(hbox, labelText);
    }

    @Override
    public HBox topPartOfWindow(HBox hbox) {
        HBox baseBox = super.topPartOfWindow(hbox);
        email.setPrefSize(510,20);

        Button addEmail = button.setButtonSize("Add Email",100, 20);

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(addEmail,new Insets(20,0,0,10));
        hbox.getChildren().add(addEmail);
        return baseBox;
    }

    @Override
    public HBox middlePartOfWindow(HBox hbox) {
        TextArea showEmails = new TextArea();
        showEmails.setPrefSize(670,0);
        hbox.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(showEmails,new Insets(50,0,0,0));
        hbox.getChildren().add(showEmails);
        return hbox;
    }

    @Override
    public VBox separator(VBox vboxSeparator) {
        return super.separator(vboxSeparator);
    }

    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        Button cancel = button.setButtonSize("Cancel",100, 20);

        cancel.setOnAction( e->{
            Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
            currentlyWindow.close();

            try {
                new Main().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(10,0,12,35));
        hbox.getChildren().add(cancel);
        return hbox;
    }
}
