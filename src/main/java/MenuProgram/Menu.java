package MenuProgram;

import JavaFXClasses.ButtonManager;
import JavaFXClasses.SceneManager;
import JavaFXClasses.SetEmail;
import JavaFXClasses.Settings;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Menu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // SceneManager class set scene
        SceneManager sceneManager = new SceneManager(stage);

        //Menu Label view
        Label label = new Label("Menu");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        label.setAlignment(Pos.CENTER);

        //Menu buttons option
        ButtonManager button = new ButtonManager();
        Button setEmails = button.setButtonSize("Set Emails",200, 40);
        Button settings = button.setButtonSize("Settings",200, 40);
        Button exit = button.setButtonSize("Exit",200, 40);

        //Buttons actions
        setEmails.setOnAction(e->{
            SetEmail setEmail = new SetEmail();
            HBox titleSetEmailsHBox = new HBox();
            VBox inputPartOfWindowVBox = new VBox();
            VBox vboxSeparator = new VBox();
            HBox buttonPartOfWindowHBox = new HBox();

            setEmail.title(titleSetEmailsHBox ,"Set Emails and Generate Description");
            setEmail.inputPartOfWindow(inputPartOfWindowVBox);
            setEmail.separator(vboxSeparator);
            setEmail.buttonPartOfWindow(buttonPartOfWindowHBox);

            // Scene and VBox settings
            VBox layout = new VBox();
            layout.getChildren().addAll(titleSetEmailsHBox ,inputPartOfWindowVBox,vboxSeparator,buttonPartOfWindowHBox);
            Scene scene = sceneManager.scenePanel(layout,700,400);
            sceneManager.openPanel(scene,"EmailAI");
            stage.setScene(scene);
            stage.setResizable(false);
        });

        settings.setOnAction(e->{
            Settings settingsClass = new Settings();
            VBox inputPartOfWindowSettingsVBox = new VBox();
            HBox titleSettingsHBox = new HBox();

            settingsClass.title(titleSettingsHBox,"Settings");
            settingsClass.inputPartOfWindow(inputPartOfWindowSettingsVBox);

            VBox layout = new VBox();
            layout.getChildren().addAll(titleSettingsHBox,inputPartOfWindowSettingsVBox);
            Scene scene = sceneManager.scenePanel(layout,700,400);
            sceneManager.openPanel(scene,"EmailAI");
            stage.setScene(scene);
            stage.setResizable(false);

        });


        //Vbox settings
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(30));
        vbox.getChildren().addAll(label,setEmails,settings,exit);

        //Menu scene
        VBox layout = new VBox();
        layout.getChildren().addAll(vbox);
        Scene scene = sceneManager.scenePanel(layout,700,400);
        sceneManager.openPanel(scene,"EmailAI");
        stage.setScene(scene);
        stage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
