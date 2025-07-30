package Settings;

import Interfaces.WindowViewInterface;
import MenuProgram.Menu;
import FileManagerClasses.FileManagerOpenAIClass;
import SetEmail.SetEmail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Settings extends SetEmail implements WindowViewInterface {
    private static final Path HOST_ADDRESS = Paths.get(MAIN_PACKAGE_FILES,"hostAddress.txt");
    private static final Path POST_OFFICE = Paths.get(MAIN_PACKAGE_FILES,"postOfficeChoose.txt");
    private static final Path POST_PASSWORD = Paths.get(MAIN_PACKAGE_FILES,"postPassword.txt");
    private static final Path PLACE_OF_CHOICE = Paths.get(MAIN_PACKAGE_FILES,"searchPoleDirection.txt");

    public File hostAddressFile = new File(String.valueOf(HOST_ADDRESS));
    public File postPasswordFile = new File(String.valueOf(POST_PASSWORD));
    public File placeOfChoiceFile = new File(String.valueOf(PLACE_OF_CHOICE));

    public FileManagerOpenAIClass postOfficeOption = new FileManagerOpenAIClass(POST_OFFICE);
    public FileManagerOpenAIClass hostAddressSave = new FileManagerOpenAIClass(hostAddressFile.toPath());
    public FileManagerOpenAIClass postPasswordSave = new FileManagerOpenAIClass(postPasswordFile.toPath());
    public FileManagerOpenAIClass apiKeySave = new FileManagerOpenAIClass(apiFile.toPath());
    public FileManagerOpenAIClass placeOfChoiceSave = new FileManagerOpenAIClass(placeOfChoiceFile.toPath());

    public PasswordField apiFieldKey = new PasswordField();
    public PasswordField tokenOrPasswordPostOfficeField = new PasswordField();
    public TextField hostAddressField = new TextField();
    public TextField placeOfChoiceLabelField = new TextField();

    public ObservableList<String> postOfficess = FXCollections.observableArrayList("Gmail","Outlook","Wp","Onet");
    public ComboBox<String> postOfficeBox = new ComboBox<>(postOfficess);

    Button cancel = button.setButtonSize("Cancel",100, 20);
    Button save = button.setButtonSize("Save",100, 20);

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

        // Label and textfield for Key AI and read file function
        Label apiOpenKeyLabel = new Label("Key AI");
        apiOpenKeyLabel.setFont(Font.font(15));
        apiFieldKey.setPrefSize(530,20);

        //Show content api key file
        String apiKey = apiKeySave.readFile(apiFile);
        apiFieldKey.setText(apiKey);

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
        hostAddressField.setPrefSize(530,20);

        // Show contail host adress file
        String hostAdress = hostAddressSave.readFile(hostAddressFile);
        hostAddressField.setText(hostAdress);

        HBox hostAdressHBox = new HBox();
        hostAdressHBox.setAlignment(Pos.TOP_LEFT);
        hostAdressHBox.getChildren().addAll(hostAdressLabel, hostAddressField);
        HBox.setMargin(hostAdressLabel,new Insets(20,25,0,10));
        HBox.setMargin(hostAddressField,new Insets(20,0,0,10));

        //Label and PasswordField for email token or password
        Label tokenOrPostOfficePasswordLabel = new Label("Post Password");
        tokenOrPostOfficePasswordLabel.setFont(Font.font(15));
        tokenOrPasswordPostOfficeField.setPrefSize(530,20);

        //Show content post password file
        String postPassword = postPasswordSave.readFile(postPasswordFile);
        tokenOrPasswordPostOfficeField.setText(postPassword);

        HBox tokenOrPasswordPostOfficeHBox = new HBox();
        tokenOrPasswordPostOfficeHBox.setAlignment(Pos.TOP_LEFT);
        tokenOrPasswordPostOfficeHBox.getChildren().addAll(tokenOrPostOfficePasswordLabel,tokenOrPasswordPostOfficeField);
        HBox.setMargin(tokenOrPostOfficePasswordLabel,new Insets(20,10,0,10));
        HBox.setMargin(tokenOrPasswordPostOfficeField,new Insets(20,0,0,10));

        //Label and PasswordField for email token or password
        Label placeOfChoiceLabel = new Label("Place of choice");
        placeOfChoiceLabel.setFont(Font.font(15));
        placeOfChoiceLabelField.setPrefSize(530,20);

        //Show content post password file
        String placeOfChoice = placeOfChoiceSave.readFile(placeOfChoiceFile);
        placeOfChoiceLabelField.setText(placeOfChoice);

        HBox pathForSearchPlaceOfFileHBox = new HBox();
        pathForSearchPlaceOfFileHBox.setAlignment(Pos.TOP_LEFT);
        pathForSearchPlaceOfFileHBox.getChildren().addAll(placeOfChoiceLabel,placeOfChoiceLabelField);
        HBox.setMargin(placeOfChoiceLabel,new Insets(20,7,0,10));
        HBox.setMargin(placeOfChoiceLabelField,new Insets(20,0,0,10));

        vbox.getChildren().addAll(apiHBox,postOfficeHBox,hostAdressHBox,tokenOrPasswordPostOfficeHBox,pathForSearchPlaceOfFileHBox);

        return vbox;
    }

    @Override
    public VBox separator(VBox vboxSeparator) {
        separator.setPrefWidth(200);

        VBox.setMargin(separator, new Insets(70, 0, 0, 0));
        vboxSeparator.getChildren().addAll(separator);

        return vboxSeparator;
    }

    @Override
    public HBox buttonPartOfWindow(HBox hbox) {

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
          String checkAPIKey = apiFieldKey.getText().trim();
          String choosePostOfficeOption = postOfficeBox.getValue();
          String checkHostAdress = hostAddressField.getText().trim();
          String checkPostPassword = tokenOrPasswordPostOfficeField.getText().trim();
          String checkPlaceOfChoice = placeOfChoiceLabelField.getText().trim();

          if(checkAPIKey.isEmpty()){
              alert.alertMessage("Empty field!", "❌ Your API Key field is empty");
              return;
          }
          if(checkHostAdress.isEmpty()){
              alert.alertMessage("Empty field!", "❌ Your Host Adress field is empty");
              return;
          }
          if(checkPostPassword.isEmpty()){
              alert.alertMessage("Empty field!", "❌ Your Post Password field is empty");
              return;
          }
            if(checkPlaceOfChoice.isEmpty()){
                alert.alertMessage("Empty field!", "❌ Your Place of choice field is empty");
                return;
            }


          boolean saveAPIKey = apiKeySave.writeToFile(checkAPIKey);
          boolean saveChoosePostOfficeOption = postOfficeOption.writeToFile(choosePostOfficeOption);
          boolean saveHostAdress = hostAddressSave.writeToFile(checkHostAdress);
          boolean savePostPassword = postPasswordSave.writeToFile(checkPostPassword);
          boolean savePlaceOfChoice = placeOfChoiceSave.writeToFile(checkPlaceOfChoice);

          if(saveAPIKey && saveChoosePostOfficeOption && saveHostAdress && savePostPassword && savePlaceOfChoice){
              alert.alertMessage("Succes","✅ Settings are saving");
          }

        });

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(10,0,12,35));
        HBox.setMargin(save,new Insets(10,10,12,10));
        hbox.getChildren().addAll(cancel, save);

        return hbox;
    }
}
