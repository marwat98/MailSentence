package MainProgramFile;

import FileClass.FileClass;
import GmailSendMessage.GmailSend;
import InformationClass.Sentence;
import JavaFXClass.ButtonManager;
import JavaFXClass.SceneManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.io.IOException;
import javafx.scene.control.Label;
import java.util.Scanner;

public class Main  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager sceneManager = new SceneManager(stage);
        EmailValidator email = EmailValidator.getInstance();
        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
        FileClass file = new FileClass(myEmailFile);

        //Menu Label view
        Label label = new Label("Menu");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        label.setAlignment(Pos.CENTER);

        //Menu buttons option
        ButtonManager button = new ButtonManager();
        Button setYourEmail = button.setButtonSize("Set Your Email");
        Button setSendEmail = button.setButtonSize("Set Send Email");
        Button settings = button.setButtonSize("Settings");
        Button exit = button.setButtonSize("Exit");

        //Buttons actions
        setYourEmail.setOnAction(e->{
            //Scene where you set your email
            VBox vboxYourEmail = new VBox();
            Button buttonReturn = new Button("Return");
            Separator separator = new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);

            VBox.setMargin(buttonReturn,new Insets(10,0,0,10));
            VBox.setMargin(separator,new Insets(10,0,10,0));
            vboxYourEmail.getChildren().addAll(buttonReturn,separator);

            HBox hboxYourEmail = new HBox(10);
            Button buttonCancel = new Button("Cancel");
            Button buttonSave = new Button("Save");
            hboxYourEmail.setAlignment(Pos.BOTTOM_RIGHT);
            HBox.setMargin(buttonSave,new Insets(0,50,50,0));
            HBox.setMargin(buttonCancel,new Insets(0,0,50,0));

            StackPane pane = new StackPane(vboxYourEmail,hboxYourEmail);
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
//        Scanner scanner = new Scanner(System.in);
//        Sentence showSentence = new Sentence();
//        EmailValidator email = EmailValidator.getInstance();
//        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
//        FileClass file = new FileClass(myEmailFile);
//        int choose;
//
//
//        showSentence.printMenu();
//        showSentence.show("Choose: ");
//        choose = scanner.nextInt();
//
//        switch(choose){
//            case 1 ->{
//                showSentence.printChooseOne();
//                showSentence.show("Choose: ");
//                choose = scanner.nextInt();
//
//                if(choose == 1){
//                    String writeEmail = scanner.next();
//                    String checkWriteEmail = (email.isValid(writeEmail)) ? "Sucess!! Your email is right" : "You write wrong email try again";
//                    System.out.println(checkWriteEmail);
//                    file.writeEmailInFile(writeEmail);
//                } else {
//                    try {
//                        file.showEmails();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//            case 2 ->{
//
//            }
//        }
//
//        GmailSend gmail = new GmailSend("yourmail@gmail.com","sendmail@gmail.com","hostAdress","appPassword");

    }
}
