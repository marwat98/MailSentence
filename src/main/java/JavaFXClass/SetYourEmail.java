package JavaFXClass;

import Interfaces.WindowViewInterface;
import MainProgramFile.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;

public class SetYourEmail implements WindowViewInterface {
    File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
    FileClass file = new FileClass(myEmailFile);
    TextField email = new TextField();
    TextField readText = new TextField();
    RefreshWindow refresh = new RefreshWindow();

    // method which have settings position title on window
    public HBox title(HBox hbox){
        Label writeYourEmail = new Label("Write your email or change");
        writeYourEmail.setFont(Font.font(20));

        hbox.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(writeYourEmail,new Insets(35,0,0,0));
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

        email.setPrefSize(575,20);

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(label,new Insets(100,0,0,15));
        HBox.setMargin(email,new Insets(100,0,0,20));
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
        Label contain = new Label("Your currently email");
        contain.setFont(Font.font(15));
        contain.setTextAlignment(TextAlignment.CENTER);
        contain.setAlignment(Pos.CENTER);
        contain.setWrapText(true);

        readText.setPrefSize(300,30);
        readText.setEditable(false);
        String showContent = file.showEmails();
        readText.setText(showContent);


        hbox.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(contain,new Insets(155,20,0,0));
        HBox.setMargin(readText,new Insets(150,0,0,0));
        hbox.getChildren().addAll(contain,readText);

        return hbox;
    }

    // method which contain settings for position separator on window
    public VBox separator(VBox vboxSeparator){
        Separator separator = new Separator();
        separator.setPrefWidth(200);

        VBox.setMargin(separator, new Insets(350, 0, 0, 0));
        vboxSeparator.getChildren().addAll(separator);

        return vboxSeparator;
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
        Button save = button.setButtonSize("Save",100, 20);

        cancel.setOnAction( e->{
            Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
            currentlyWindow.close();

            try {
                new Main().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        save.setOnAction(e->{
            file.writeEmailInFile(email.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes");
            alert.setHeaderText(null);
            alert.setContentText("You save email " + email.toString());
            alert.showAndWait();
            refresh.refreshWindow(readText);
        });

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(0,0,12,35));
        HBox.setMargin(save,new Insets(0,10,12,10));
        hbox.getChildren().addAll(cancel,save);

        return hbox;
    }
}
