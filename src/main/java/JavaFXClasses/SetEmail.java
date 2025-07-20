package JavaFXClasses;

import Interfaces.AlertInterface;
import OpenAI.OpenAIConfigurator;
import ProgramFileClasses.FileSetSendEmailClass;
import ProgramFileClasses.FileSetYourEmailClass;
import Interfaces.WindowViewInterface;
import MenuProgram.Menu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;

public class SetEmail implements WindowViewInterface , AlertInterface {
    protected File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
    protected File toSendEmail = new File("src/main/java/ProgramFiles/sendEmailFile.txt");
    FileSetYourEmailClass fileSetYourEmailClass = new FileSetSendEmailClass(myEmailFile);
    FileSetSendEmailClass fileSetSendEmailClass = new FileSetSendEmailClass(toSendEmail);
    TextField fromSetEmail = new TextField();
    TextField toSetEmail = new TextField();
    RefreshWindow refresh = new RefreshWindow();
    ButtonManager button = new ButtonManager();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    // method which have settings position title on window
    @Override
    public HBox title(HBox hbox,String labelText){
        Label writeYourEmail = new Label(labelText);
        writeYourEmail.setFont(Font.font(15));

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(writeYourEmail,new Insets(25,0,0,100));
        hbox.getChildren().addAll(writeYourEmail);

        return hbox;
    }


    @Override
    public VBox inputPartOfWindow(VBox vbox ) {

        // Label and TextField for From email input
        Label fromEmailLabel = new Label("From");
        fromEmailLabel.setFont(Font.font(15));
        fromSetEmail.setPrefSize(530,20);

        // Label and TextField for To email input
        Label toEmailLabel = new Label("To");
        toEmailLabel.setFont(Font.font(15));
        toSetEmail.setPrefSize(530,20);

        //Label and TextField for title input
        Label titleLabel = new Label("Title");
        titleLabel.setFont(Font.font(15));
        TextField title = new TextField();
        title.setPrefSize(530,20);

        //Label and TextArea for Description Email
        Label descriptionLabel = new Label("Description");
        descriptionLabel.setFont(Font.font(15));
        TextArea description = new TextArea();
        description.setPrefSize(530,130);

        //Button to generate title and
        Button generateButton = button.setButtonSize("Generate",200,20);
        generateButton.setOnAction(e->{
            OpenAIConfigurator openAI = new OpenAIConfigurator();
            String greetingsTitle = openAI.generate("Generate title for email with greetings only once");
            title.setText(greetingsTitle);
        });


        HBox fromRow = new HBox();
        fromRow.setAlignment(Pos.TOP_LEFT);
        fromRow.getChildren().addAll(fromEmailLabel,fromSetEmail);
        HBox.setMargin(fromEmailLabel,new Insets(15,40,0,15));
        HBox.setMargin(fromSetEmail,new Insets(15,0,0,10));

        HBox toRow = new HBox();
        toRow.setAlignment(Pos.TOP_LEFT);
        toRow.getChildren().addAll(toEmailLabel,toSetEmail);
        HBox.setMargin(toEmailLabel,new Insets(15,57,0,15));
        HBox.setMargin(toSetEmail,new Insets(15,0,0,10));

        HBox titleRow = new HBox();
        titleRow.setAlignment(Pos.TOP_LEFT);
        titleRow.getChildren().addAll(titleLabel,title);
        HBox.setMargin(titleLabel,new Insets(15,45,0,15));
        HBox.setMargin(title,new Insets(15,0,0,10));

        HBox descriptionRow = new HBox();
        descriptionRow.setAlignment(Pos.TOP_LEFT);
        descriptionRow.getChildren().addAll(descriptionLabel,description);
        HBox.setMargin(descriptionLabel,new Insets(45,-2,0,15));
        HBox.setMargin(description,new Insets(15,0,0,10));

        HBox generateRow = new HBox();
        generateRow.setAlignment(Pos.BOTTOM_CENTER);
        generateRow.getChildren().add(generateButton);
        HBox.setMargin(generateButton,new Insets(10,0,0,0));

        vbox.getChildren().addAll(fromRow,toRow,titleRow,descriptionRow,generateRow);

        return vbox;
    }


    // method which contain settings for position separator on window
    @Override
    public VBox separator(VBox vboxSeparator){
        Separator separator = new Separator();
        separator.setPrefWidth(200);

        VBox.setMargin(separator, new Insets(40, 0, 0, 0));
        vboxSeparator.getChildren().addAll(separator);

        return vboxSeparator;
    }


    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        Button cancel = button.setButtonSize("Cancel",100, 20);
        Button save = button.setButtonSize("Save",100, 20);

        cancel.setOnAction( e->{
            Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
            currentlyWindow.close();
            try {
                new Menu().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        save.setOnAction(e->{
            if(fileSetYourEmailClass.writeEmailToFile(fromSetEmail.getText())){
                sucess(alert);
            } else if (fromSetEmail.getText().isEmpty() || fromSetEmail.getText().equals("")){
                emptyField(alert);
            } else {
               errorField(alert);
            }
            if(fileSetSendEmailClass.writeEmailToFile(toSetEmail.getText())){
                sucess(alert);
            } else if (toSetEmail.getText().isEmpty() || toSetEmail.getText().equals("")){
                emptyField(alert);
            } else {
                errorField(alert);
            }
          });

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(10,0,12,35));
        HBox.setMargin(save,new Insets(10,10,12,10));
        hbox.getChildren().addAll(cancel,save);

        return hbox;
    }
}
