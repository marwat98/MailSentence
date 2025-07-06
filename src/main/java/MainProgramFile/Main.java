package MainProgramFile;

import JavaFXClass.ButtonManager;
import JavaFXClass.SceneManager;
import JavaFXClass.SetSendEmail;
import JavaFXClass.SetYourEmail;
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
import org.apache.commons.validator.routines.EmailValidator;
import javafx.scene.control.Label;

public class Main  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager sceneManager = new SceneManager(stage);
        EmailValidator email = EmailValidator.getInstance();

        //Menu Label view
        Label label = new Label("Menu");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        label.setAlignment(Pos.CENTER);

        //Menu buttons option
        ButtonManager button = new ButtonManager();
        Button setYourEmail = button.setButtonSize("Set Your Email",200, 40);
        Button setSendEmail = button.setButtonSize("Set Send Email",200, 40);
        Button settings = button.setButtonSize("Settings",200, 40);
        Button exit = button.setButtonSize("Exit",200, 40);

        //Buttons actions
        setYourEmail.setOnAction(e->{
            SetYourEmail setEmail = new SetYourEmail();
            HBox writeYourEmail = new HBox();
            HBox hbox = new HBox(10);
            HBox hboxMiddleArea = new HBox();
            HBox hboxButtons = new HBox();
            VBox vboxSeparator = new VBox();
            setEmail.title(writeYourEmail,"Write your email or change");
            setEmail.topPartOfWindow(hbox);
            setEmail.middlePartOfWindow(hboxMiddleArea);
            setEmail.separator(vboxSeparator);
            setEmail.buttonPartOfWindow(hboxButtons);

            // Scene and StackPane settings
            StackPane pane = new StackPane(hbox,writeYourEmail,hboxMiddleArea,vboxSeparator,hboxButtons);
            Scene scene = sceneManager.scenePanel(pane,700,400);
            sceneManager.openPanel(scene,"EmailAI");
        });

        setSendEmail.setOnAction(e->{
            SetSendEmail setSendEmails = new SetSendEmail();
            HBox titleHbox = new HBox();
            HBox topPartOfWindowHBox = new HBox();
            HBox buttonPartOfWindowHBox = new HBox();
            VBox vboxSeparatorSendEmail = new VBox();
            setSendEmails.title(titleHbox,"Set email to send");
            setSendEmails.topPartOfWindow(topPartOfWindowHBox);
            setSendEmails.separator(vboxSeparatorSendEmail);
            setSendEmails.buttonPartOfWindow(buttonPartOfWindowHBox);

            StackPane pane = new StackPane(titleHbox,topPartOfWindowHBox,vboxSeparatorSendEmail,buttonPartOfWindowHBox);
            Scene scene = sceneManager.scenePanel(pane,700,400);
            sceneManager.openPanel(scene,"EmailAI");
        });


        //Vbox settings
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(30));
        vbox.getChildren().addAll(label,setYourEmail,setSendEmail,settings,exit);

        //Menu scene
        StackPane paneMenu = new StackPane(vbox);
        Scene sceneMenu = sceneManager.scenePanel(paneMenu,700,400);
        sceneManager.openPanel(sceneMenu,"EmailAI");


    }
    public static void main(String[] args) {
        launch(args);
    }
}
