package JavaFXClasses;

import Interfaces.AlertInterface;
import OpenAI.OpenAIConfigurator;
import ProgramFileClasses.FileOpenAIClass;
import ProgramFileClasses.FileSetSendEmailClass;
import ProgramFileClasses.FileManagerClass;
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
import java.util.Set;

public class SetEmail implements WindowViewInterface , AlertInterface {
    private final String fromPath = "src/main/java/ProgramFiles/myEmailFile.txt";
    private final String toPath = "src/main/java/ProgramFiles/sendEmailFile.txt";
    private final String titlePath = "src/main/java/ProgramFiles/emailTitleFile.txt";
    private final String apiPath = "src/main/java/ProgramFiles/APIKEY.txt";
    private final File myEmailFile = new File(fromPath);
    private final File sendEmailFile = new File(toPath);
    private final File titleFile = new File(titlePath);
    private final File apiFile = new File(apiPath);
    FileManagerClass fileSetYourEmailClass = new FileManagerClass(myEmailFile);
    FileOpenAIClass titleAI = new FileOpenAIClass(titleFile);
    FileSetSendEmailClass fileSetSendEmailClass = new FileSetSendEmailClass(sendEmailFile);
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

    /**
     * method which conatin inputs for prepare to send message email
     * @param vbox
     * @return vbox of settings position inputs on window
     */
    @Override
    public VBox inputPartOfWindow(VBox vbox ) {

        // Label and TextField for From email input
        Label fromEmailLabel = new Label("From");
        fromEmailLabel.setFont(Font.font(15));
        fromSetEmail.setPrefSize(530,20);

        //Loop which show email in input fromSetEmail
        Set<String> myEmailData = fileSetYourEmailClass.showEmails();
        for (String data : myEmailData){
            fromSetEmail.setText(data);
        }

        // Label and TextField for To email input
        Label toEmailLabel = new Label("To");
        toEmailLabel.setFont(Font.font(15));
        toSetEmail.setPrefSize(530,20);

        //Loop which show emails in input toSetEmail
        Set<String> toSendEmailData = fileSetSendEmailClass.showEmails();
        for (String data : toSendEmailData){
            toSetEmail.setText(data);
        }

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

        //Button to generate title and descirption of using OpenAI
        Button generateButton = button.setButtonSize("Generate",200,20);
        generateButton.setOnAction(e->{
            // OpenAIConguration object with methods
            OpenAIConfigurator openAIConfigurator = new OpenAIConfigurator();
            String apiKey = openAIConfigurator.readAPIKey(apiFile);
            String generateTitle  = openAIConfigurator.generate("Generate only one email title with greetings without description",apiKey);
            // Input which set generated title
            title.setText(generateTitle);
            // Variable which get title of input
            String input = title.getText();
            // Method writeTOFile which save title in file
            titleAI.writeToFile(input);
            // Loop which show title text in input
            Set<String> showTitleAI = titleAI.showEmails();
            for (String data : showTitleAI){
                title.setText(data);
            }
            // Method refreshWindow which refresh input after completed input
            refresh.refreshWindow(title,titlePath);

        });

        // HBox for field "From" with settings inputs and label on window
        HBox fromRow = new HBox();
        fromRow.setAlignment(Pos.TOP_LEFT);
        fromRow.getChildren().addAll(fromEmailLabel,fromSetEmail);
        HBox.setMargin(fromEmailLabel,new Insets(15,40,0,15));
        HBox.setMargin(fromSetEmail,new Insets(15,0,0,10));

        // HBox for field "To" with settings inputs and label on window
        HBox toRow = new HBox();
        toRow.setAlignment(Pos.TOP_LEFT);
        toRow.getChildren().addAll(toEmailLabel,toSetEmail);
        HBox.setMargin(toEmailLabel,new Insets(15,57,0,15));
        HBox.setMargin(toSetEmail,new Insets(15,0,0,10));

        // HBox for field "Title" with settings inputs and label on window
        HBox titleRow = new HBox();
        titleRow.setAlignment(Pos.TOP_LEFT);
        titleRow.getChildren().addAll(titleLabel,title);
        HBox.setMargin(titleLabel,new Insets(15,45,0,15));
        HBox.setMargin(title,new Insets(15,0,0,10));

        // HBox for field "Description" with settings inputs and label on window
        HBox descriptionRow = new HBox();
        descriptionRow.setAlignment(Pos.TOP_LEFT);
        descriptionRow.getChildren().addAll(descriptionLabel,description);
        HBox.setMargin(descriptionLabel,new Insets(45,-2,0,15));
        HBox.setMargin(description,new Insets(15,0,0,10));

        // HBox for button generate message and title of using OpenAI
        HBox generateRow = new HBox();
        generateRow.setAlignment(Pos.BOTTOM_CENTER);
        generateRow.getChildren().add(generateButton);
        HBox.setMargin(generateButton,new Insets(10,0,0,0));

        vbox.getChildren().addAll(fromRow,toRow,titleRow,descriptionRow,generateRow);

        return vbox;
    }


    /**
     * method which set separator position on window
     * @param vboxSeparator
     * @return vbox with settings separator position
     */
    @Override
    public VBox separator(VBox vboxSeparator){
        Separator separator = new Separator();
        separator.setPrefWidth(200);

        VBox.setMargin(separator, new Insets(40, 0, 0, 0));
        vboxSeparator.getChildren().addAll(separator);

        return vboxSeparator;
    }

    /**
     * method with button cancel and save on window
     * @param hbox
     * @return hbox with position buttons cancel and save on window
     */
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
        // Action saving emails in file
        save.setOnAction(e->{
            String fromEmail = fromSetEmail.getText().trim();
            String toEmail = toSetEmail.getText().trim();

            if(fromEmail.isEmpty() && toEmail.isEmpty()){
                emptyField(alert);
                return;
            }
            boolean fromSavedToFile = fileSetYourEmailClass.writeToFile(fromSetEmail.getText());
            boolean toSavedToFile = fileSetSendEmailClass.writeToFile(toSetEmail.getText());

            if(fromSavedToFile && toSavedToFile){
                sucess(alert);
                refresh.refreshWindow(fromSetEmail,fromPath);
                refresh.refreshWindow(toSetEmail,toPath);
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