package MainProgram;

import JavaFXClasses.ButtonManager;
import JavaFXClasses.SceneManager;
import JavaFXClasses.SetSendEmail;
import JavaFXClasses.SetYourEmail;
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
            HBox topOfWindowYourEmailHBox = new HBox(10);
            HBox middleOfWindowYourEmailHBox = new HBox();
            HBox buttonOfWindowYourEmailHBox = new HBox();
            VBox vboxSeparator = new VBox();
            setEmail.title(writeYourEmail,"Write your email or change");
            setEmail.topPartOfWindow(topOfWindowYourEmailHBox);
            setEmail.middlePartOfWindow(middleOfWindowYourEmailHBox);
            setEmail.separator(vboxSeparator);
            setEmail.buttonPartOfWindow(buttonOfWindowYourEmailHBox);

            // Scene and VBox settings
            VBox layout = new VBox();
            layout.getChildren().addAll(writeYourEmail,topOfWindowYourEmailHBox,middleOfWindowYourEmailHBox,vboxSeparator,buttonOfWindowYourEmailHBox);
            Scene scene = sceneManager.scenePanel(layout,700,400);
            sceneManager.openPanel(scene,"EmailAI");
        });

        setSendEmail.setOnAction(e->{
            SetSendEmail setSendEmails = new SetSendEmail();
            HBox titleHbox = new HBox();
            HBox topOfWindowSendEmailHBox = new HBox();
            HBox middleOfWindowSendEmailHBox = new HBox();
            VBox separatorSendEmailVBox = new VBox();
            HBox buttonOfWindowSendEmailHBox= new HBox();
            setSendEmails.title(titleHbox,"Set email to send");
            setSendEmails.topPartOfWindow(topOfWindowSendEmailHBox);
            setSendEmails.middlePartOfWindow(middleOfWindowSendEmailHBox);
            setSendEmails.separator(separatorSendEmailVBox);
            setSendEmails.buttonPartOfWindow(buttonOfWindowSendEmailHBox);

            VBox layout = new VBox();
            layout.getChildren().addAll(titleHbox,topOfWindowSendEmailHBox,middleOfWindowSendEmailHBox,separatorSendEmailVBox,buttonOfWindowSendEmailHBox);
            Scene scene = sceneManager.scenePanel(layout,700,400);
            sceneManager.openPanel(scene,"EmailAI");
        });

        //Vbox settings
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(30));
        vbox.getChildren().addAll(label,setYourEmail,setSendEmail,settings,exit);

        //Menu scene
        VBox layout = new VBox();
        layout.getChildren().addAll(vbox);
        Scene scene = sceneManager.scenePanel(layout,700,400);
        sceneManager.openPanel(scene,"EmailAI");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
