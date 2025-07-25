package JavaFXClasses;

import OpenAI.OpenAIConfigurator;
import ProgramFileClasses.FileOpenAIClass;
import ProgramFileClasses.FileSetSendEmailClass;
import ProgramFileClasses.FileManagerClass;
import Alert.AlertClass;
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
import java.nio.file.Path;
import java.nio.file.Paths;

public class SetEmail implements WindowViewInterface{
    public static final String MAIN_PACKAGE_FILES = "src/main/ProgramFiles";
    private static final Path FROM_PATH = Paths.get(MAIN_PACKAGE_FILES , "myEmailFile.txt");
    private static final Path TO_PATH = Paths.get(MAIN_PACKAGE_FILES, "sendEmailFile.txt");
    private static final Path TITLE_PATH = Paths.get(MAIN_PACKAGE_FILES , "emailTitleFile.txt");
    private static final Path API_PATH = Paths.get(MAIN_PACKAGE_FILES , "APIKEY.txt");
    private static final Path DESTRIPTION_PATH = Paths.get(MAIN_PACKAGE_FILES , "descriptionFile.txt");
    private static final Path LINK = Paths.get(MAIN_PACKAGE_FILES, "link.txt");

    public File myEmailFile = new File(String.valueOf(FROM_PATH));
    public File sendEmailFile = new File(String.valueOf(TO_PATH));
    public File titleFile = new File(String.valueOf(TITLE_PATH));
    public File apiFile = new File(String.valueOf(API_PATH));
    public File descriptionFile = new File(String.valueOf(DESTRIPTION_PATH));
    public File linkFile = new File(String.valueOf(LINK));

    public FileManagerClass fileSetYourEmailClass = new FileManagerClass(myEmailFile.toPath());
    public FileManagerClass readLinkOfFile = new FileManagerClass(linkFile.toPath());
    public FileOpenAIClass fileOpenAI = new FileOpenAIClass(titleFile.toPath());
    public FileOpenAIClass descriptionOpenAI = new FileOpenAIClass(descriptionFile.toPath());
    public FileSetSendEmailClass fileSetSendEmailClass = new FileSetSendEmailClass(sendEmailFile.toPath());

    public TextField fromSetEmail = new TextField();
    public TextField toSetEmail = new TextField();
    public Separator separator = new Separator();
    public RefreshWindow refresh = new RefreshWindow();
    public ButtonManager button = new ButtonManager();
    public AlertClass alert = new AlertClass();

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

        // Label and TextField for From email input and HBox
        Label fromEmailLabel = new Label("From");
        fromEmailLabel.setFont(Font.font(15));
        fromSetEmail.setPrefSize(530,20);

        HBox fromRow = new HBox();
        fromRow.setAlignment(Pos.TOP_LEFT);
        fromRow.getChildren().addAll(fromEmailLabel,fromSetEmail);
        HBox.setMargin(fromEmailLabel,new Insets(15,40,0,15));
        HBox.setMargin(fromSetEmail,new Insets(15,0,0,10));

        //Loop which show email in input fromSetEmail
        String myEmailData = fileSetYourEmailClass.showContent();
        fromSetEmail.setText(myEmailData);


        // Label and TextField for To email input and HBox
        Label toEmailLabel = new Label("To");
        toEmailLabel.setFont(Font.font(15));
        toSetEmail.setPrefSize(530,20);

        HBox toRow = new HBox();
        toRow.setAlignment(Pos.TOP_LEFT);
        toRow.getChildren().addAll(toEmailLabel,toSetEmail);
        HBox.setMargin(toEmailLabel,new Insets(15,57,0,15));
        HBox.setMargin(toSetEmail,new Insets(15,0,0,10));

        //Loop which show emails in input toSetEmail
        String toSendEmailData = fileSetSendEmailClass.showContent();
        toSetEmail.setText(toSendEmailData);


        //Label,TextField,Hbox for title input
        Label titleLabel = new Label("Title");
        titleLabel.setFont(Font.font(15));
        TextField title = new TextField();
        title.setPrefSize(530,20);

        HBox titleRow = new HBox();
        titleRow.setAlignment(Pos.TOP_LEFT);
        titleRow.getChildren().addAll(titleLabel,title);
        HBox.setMargin(titleLabel,new Insets(15,45,0,15));
        HBox.setMargin(title,new Insets(15,0,0,10));

        // Loop which show title text in input
        String showTitleAI = fileOpenAI.showContent();
        title.setText(showTitleAI);

        //Label,TextArea,HBox for Description Email
        Label descriptionLabel = new Label("Description");
        descriptionLabel.setFont(Font.font(15));
        TextArea description = new TextArea();
        description.setPrefSize(530,130);

        HBox descriptionRow = new HBox();
        descriptionRow.setAlignment(Pos.TOP_LEFT);
        descriptionRow.getChildren().addAll(descriptionLabel,description);
        HBox.setMargin(descriptionLabel,new Insets(45,-2,0,15));
        HBox.setMargin(description,new Insets(15,0,0,10));

        String showDescriptionAI = descriptionOpenAI.showContent();
        description.setText(showDescriptionAI);

        //Button to generate title and descirption of using OpenAI
        Button generateButton = button.setButtonSize("Generate",200,20);
        generateButton.setOnAction(e->{

            // OpenAIConguration object with methods
            OpenAIConfigurator openAIConfigurator = new OpenAIConfigurator();
            // Varaible which read File
            String apiKey = fileOpenAI.readFile(apiFile);
            // Variable which generate title using OpenAI
            String generateTitle  = openAIConfigurator.generate("Generate only one email title with sales offer and date when this offer finish",apiKey);
            // Input which set generated title
            title.setText(generateTitle);
            // Variable which get title of input
            String input = title.getText();
            // Method writeTOFile which save title in file
            Boolean writeTitle = fileOpenAI.writeToFile(input);
            if(writeTitle == true){
                alert.alertMessage("Succes","✅ Generating title");
            } else {
                alert.alertMessage("Fail","❌ Generating title fail!");
            }
            // Method refreshWindow which refresh input after completed input
            refresh.refreshWindow(title, TITLE_PATH);

            String readTitle = fileOpenAI.readFile(titleFile);
            String generateDescription  = openAIConfigurator.generate("Generate a description based on the title inside the file I added"
                    + readTitle +
                    "Sentence have to max 10 words on the end write Look more and click in link below additionaly in the next line add link of file" + readLinkOfFile.showContent() + "and add one empty next line and second Your sincerely Sales Menager AI",apiKey);
            description.setText(generateDescription);
            String inputDescription = description.getText();
            Boolean writeDescription = descriptionOpenAI.writeToFile(inputDescription);
            if(writeDescription == true){
                alert.alertMessage("Succes","✅ Generating descirption");
            } else {
                alert.alertMessage("Fail","❌ Generating description fail!");
            }
            refresh.refreshWindow(description,DESTRIPTION_PATH);
        });

        // Action saving emails in file
        Button saveButton = button.setButtonSize("Save",200, 20);
        saveButton.setOnAction(e->{
            String fromEmail = fromSetEmail.getText().trim();
            String toEmail = toSetEmail.getText().trim();

            if(fromEmail.isEmpty() && toEmail.isEmpty()){
                alert.alertMessage("Empty field!", "❌ Your field is empty");
            }
            boolean fromSavedToFile = fileSetYourEmailClass.writeToFile(fromSetEmail.getText());
            boolean toSavedToFile = fileSetSendEmailClass.writeToFile(toSetEmail.getText());

            if(fromSavedToFile && toSavedToFile){
                alert.alertMessage("Success", "✅ You save email");
                refresh.refreshWindow(fromSetEmail,FROM_PATH);
                refresh.refreshWindow(toSetEmail,TO_PATH);
            } else {
                alert.alertMessage("Fail!","❌ Saving email in file failing");
            }
        });

        // HBox for button generate message and title of using OpenAI
        HBox buttonRow = new HBox();
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);
        buttonRow.getChildren().addAll(generateButton,saveButton);
        HBox.setMargin(generateButton,new Insets(10,0,0,0));
        HBox.setMargin(saveButton,new Insets(10,0,0,10));

        vbox.getChildren().addAll(fromRow,toRow,titleRow,descriptionRow, buttonRow);

        return vbox;
    }


    /**
     * method which set separator position on window
     * @param vboxSeparator
     * @return vbox with settings separator position
     */
    @Override
    public VBox separator(VBox vboxSeparator){
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
        Button send = button.setButtonSize("Send",100, 20);

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

        // Action which send message
        send.setOnAction(e->{

        });

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(10,0,12,35));
        HBox.setMargin(send,new Insets(10,10,12,10));
        hbox.getChildren().addAll(cancel,send);

        return hbox;
    }
}