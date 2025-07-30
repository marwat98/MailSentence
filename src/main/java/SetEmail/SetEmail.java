package SetEmail;

import ButtonManager.ButtonManager;
import CancelOption.CancelOption;
import OpenAIConfigurator.OpenAIConfigurator;
import FileManagerClasses.FileManagerOpenAIClass;
import FileManagerClasses.FileManagerSendEmailClass;
import FileManagerClasses.FileManagerClass;
import Alert.AlertClass;
import Interfaces.WindowViewInterface;
import MenuProgram.Menu;
import RefreshWindow.RefreshWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
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
    private static final Path TEST = Paths.get(MAIN_PACKAGE_FILES, "test1.txt");

    public File myEmailFile = new File(String.valueOf(FROM_PATH));
    public File sendEmailFile = new File(String.valueOf(TO_PATH));
    public File titleFile = new File(String.valueOf(TITLE_PATH));
    public File apiFile = new File(String.valueOf(API_PATH));
    public File descriptionFile = new File(String.valueOf(DESTRIPTION_PATH));
    public File linkFile = new File(String.valueOf(LINK));
    public File testFile = new File(String.valueOf(TO_PATH));

    public FileManagerClass fileSetYourEmailClass = new FileManagerClass(myEmailFile.toPath());
    public FileManagerClass readLinkOfFile = new FileManagerClass(linkFile.toPath());
    public FileManagerOpenAIClass saveTitleOpenAI = new FileManagerOpenAIClass(titleFile.toPath());
    public FileManagerOpenAIClass descriptionOpenAI = new FileManagerOpenAIClass(descriptionFile.toPath());
    public FileManagerSendEmailClass fileSetSendEmailClass = new FileManagerSendEmailClass(sendEmailFile.toPath());


    public TextField fromSetEmail = new TextField();
    public TextField toSetEmail = new TextField();
    public TextField title = new TextField();
    public TextArea description = new TextArea();
    public Separator separator = new Separator();
    public RefreshWindow refresh = new RefreshWindow();
    public ButtonManager button = new ButtonManager();
    public AlertClass alert = new AlertClass();
    public OpenAIConfigurator openAIConfigurator = new OpenAIConfigurator();
    public Stage stage = new Stage();



    String apiKey = saveTitleOpenAI.readFile(apiFile);

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
        Label showSelectFile = new Label("No select file");

        Button select = button.setButtonSize("Select File",200, 20);
        select.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();

                fileChooser.setTitle("Choose email file");
                fileChooser.setInitialDirectory(new File("C:\\Users\\Marcin\\Desktop"));
                File selectFile = fileChooser.showOpenDialog(stage);
                FileManagerClass selectFileTest = new FileManagerClass(selectFile.toPath());
                String selectFileTest2 = selectFileTest.showContent();
                FileManagerOpenAIClass writeToFileTest = new FileManagerOpenAIClass(testFile.toPath());

                if(selectFile != null){
                    showSelectFile.setText( "Selected file: " + selectFile);
                    writeToFileTest .writeToFile(selectFileTest2);
                } else {
                    alert.alertMessage("Don't choose file", "You don't choosing file");
                }
            }
        });

        HBox toRow = new HBox();
        toRow.setAlignment(Pos.TOP_LEFT);
        toRow.getChildren().addAll(toEmailLabel,select,showSelectFile);
        HBox.setMargin(toEmailLabel,new Insets(15,57,0,15));
        HBox.setMargin(select,new Insets(15,0,0,10));
        HBox.setMargin(showSelectFile,new Insets(20,0,0,10));

        //Label,TextField,Hbox for title input
        Label titleLabel = new Label("Title");
        titleLabel.setFont(Font.font(15));
        title.setPrefSize(530,20);

        HBox titleRow = new HBox();
        titleRow.setAlignment(Pos.TOP_LEFT);
        titleRow.getChildren().addAll(titleLabel,title);
        HBox.setMargin(titleLabel,new Insets(15,45,0,15));
        HBox.setMargin(title,new Insets(15,0,0,10));

        // Loop which show title text in input
        String showTitleAI = saveTitleOpenAI.showContent();
        title.setText(showTitleAI);

        //Label,TextArea,HBox for Description Email
        Label descriptionLabel = new Label("Description");
        descriptionLabel.setFont(Font.font(15));
        description.setPrefSize(530,130);

        HBox descriptionRow = new HBox();
        descriptionRow.setAlignment(Pos.TOP_LEFT);
        descriptionRow.getChildren().addAll(descriptionLabel,description);
        HBox.setMargin(descriptionLabel,new Insets(45,-2,0,15));
        HBox.setMargin(description,new Insets(15,0,0,10));

        String showDescriptionAI = descriptionOpenAI.showContent();
        description.setText(showDescriptionAI);

        //Button to generate title and descirption of using OpenAI
        Button generateTitleButton = button.setButtonSize("Generate Title",200,20);
        generateTitleButton.setOnAction(e->{

            // Variable which generate title using OpenAI
            String generateTitle  = openAIConfigurator.generate("Generate only one email title with greetings without description",apiKey);

            // Input which set generated title
            title.setText(generateTitle);

            // Variable which get title of input
            String input = title.getText();

            // Variable which checking if writeToFile method return true
            boolean writeTitle = saveTitleOpenAI.writeToFile(input);
            if(writeTitle){
                alert.alertMessage("Succes","✅ Generating title");
            } else {
                alert.alertMessage("Fail","❌ Generating title fail!");
            }
            // refresh window after showing title
            refresh.refreshWindow(title, TITLE_PATH);
        });

        // Action saving emails in file
        Button generateDescriptionButton = button.setButtonSize("Generate Description",200, 20);
        generateDescriptionButton.setOnAction(e->{
            // Variable which read title File
            String readTitle = saveTitleOpenAI.readFile(titleFile);

            // Varaible which set description to generating
            String generateDescription  = openAIConfigurator.generate("Generate a description based on the title inside the file I added"
                    + readTitle +
                    "Sentence have to max 10 words on the end write Look more and click in link below additionaly in the next line add link of file" + readLinkOfFile.showContent()
                    + "and add one empty next line and second Your sincerely Sales Menager AI",apiKey);

            description.setText(generateDescription);

            // Variable which show description in TextField
            String inputDescription = description.getText();

            // Variable which checking if writeToFile method return true
            boolean writeDescription = descriptionOpenAI.writeToFile(inputDescription);
            if(writeDescription){
                alert.alertMessage("Succes","✅ Generating descirption");
            } else {
                alert.alertMessage("Fail","❌ Generating description fail!");
            }
            // refresh window after showing description
            refresh.refreshWindow(description,DESTRIPTION_PATH);
        });

        // HBox for button generate message and title of using OpenAI
        HBox buttonRow = new HBox();
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);
        buttonRow.getChildren().addAll(generateTitleButton, generateDescriptionButton);
        HBox.setMargin(generateTitleButton,new Insets(10,0,0,0));
        HBox.setMargin(generateDescriptionButton,new Insets(10,0,0,10));

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
        Button save = button.setButtonSize("Save",100, 20);

        // Action returning to menu window
        cancel.setOnAction( e->{
            CancelOption cancelOption = new CancelOption();
            cancelOption.cancel(cancel);
        });

        // Action which save options
        save.setOnAction(e->{
            SaveSetEmailSettings saveSetEmailSettings = new SaveSetEmailSettings();
            saveSetEmailSettings.save(fromSetEmail,title,alert,refresh);
        });

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(10,0,12,35));
        HBox.setMargin(save,new Insets(10,10,12,10));
        hbox.getChildren().addAll(cancel,save);

        return hbox;
    }
}