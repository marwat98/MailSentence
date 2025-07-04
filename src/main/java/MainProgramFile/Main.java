package MainProgramFile;

import JavaFXClass.ButtonManager;
import JavaFXClass.SceneManager;
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
            setEmail.title(writeYourEmail);
            setEmail.topPartOfWindow(hbox);
            setEmail.middlePartOfWindow(hboxMiddleArea);
            setEmail.separator(vboxSeparator);
            setEmail.buttonPartOfWindow(hboxButtons);

            // Scene and StackPane settings
            StackPane pane = new StackPane(hbox,writeYourEmail,hboxMiddleArea,vboxSeparator,hboxButtons);
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
