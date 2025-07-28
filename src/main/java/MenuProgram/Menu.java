package MenuProgram;

import JavaFXClasses.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;

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
        Button settingsAI = button.setButtonSize("AI Settings",200, 40);
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
            HBox titleSettingsHBox = new HBox();
            VBox inputPartOfWindowSettingsVBox = new VBox();
            VBox separatorSettingsVBox = new VBox();
            HBox buttonsSettingsHBox = new HBox();

            settingsClass.title(titleSettingsHBox,"Settings");
            settingsClass.inputPartOfWindow(inputPartOfWindowSettingsVBox);
            settingsClass.separator(separatorSettingsVBox);
            settingsClass.buttonPartOfWindow(buttonsSettingsHBox);

            VBox layout = new VBox();
            layout.getChildren().addAll(titleSettingsHBox,inputPartOfWindowSettingsVBox,separatorSettingsVBox,buttonsSettingsHBox);
            Scene scene = sceneManager.scenePanel(layout,700,400);
            sceneManager.openPanel(scene,"EmailAI");
            stage.setScene(scene);
            stage.setResizable(false);

        });

        settingsAI.setOnAction(e->{
            AISettings aiSettings = new AISettings();
            HBox titleAISettingsHBox = new HBox();
            VBox inputPartOfWindowAISettingsVBox = new VBox();
            VBox separatorAISettingsVBox = new VBox();
            HBox buttonsAISettingsHBox = new HBox();

            aiSettings.title(titleAISettingsHBox,"AI Settings");
            aiSettings.inputPartOfWindow(inputPartOfWindowAISettingsVBox);
            aiSettings.separator(separatorAISettingsVBox);
            aiSettings.buttonPartOfWindow(buttonsAISettingsHBox);

            VBox layout = new VBox();
            layout.getChildren().addAll(titleAISettingsHBox,inputPartOfWindowAISettingsVBox,separatorAISettingsVBox,buttonsAISettingsHBox );
            Scene scene = sceneManager.scenePanel(layout,700,400);
            sceneManager.openPanel(scene,"EmailAI");
            stage.setScene(scene);
            stage.setResizable(false);
        });

        //Vbox settings
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(30));
        vbox.getChildren().addAll(label,setEmails,settings,settingsAI,exit);

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
