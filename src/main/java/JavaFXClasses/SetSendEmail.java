package JavaFXClasses;

import ProgramFileClasses.FileSetSendEmailClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Set;


public class SetSendEmail extends SetYourEmail {
    protected ButtonManager button = new ButtonManager();
    protected File sendEmailFile = new File("src/main/java/ProgramFiles/sendEmailFile.txt");
    protected FileSetSendEmailClass fileSetSendEmailClass = new FileSetSendEmailClass(sendEmailFile);
    protected TextArea showEmails = new TextArea();

    @Override
    public HBox title(HBox hbox, String labelText) {
        return super.title(hbox, labelText);
    }

    @Override
    public HBox topPartOfWindow(HBox hbox) {
        HBox baseBox = super.topPartOfWindow(hbox);
        email.setPrefSize(510,20);

        Button addEmail = button.setButtonSize("Add Email",100, 20);
        addEmail.setOnAction(e->{
            if(fileSetSendEmailClass.writeEmailToFile(email.getText())){
                sucess(alert);
            } else if (email.getText().isEmpty() || email.getText().equals("")){
                emptyField(alert);
            } else {
               errorField(alert);
            }
        });

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(addEmail,new Insets(20,0,0,10));
        hbox.getChildren().add(addEmail);
        return baseBox;
    }

    @Override
    public HBox middlePartOfWindow(HBox hbox) {
        showEmails.setPrefSize(670,150);

       Set<String> dates = fileSetSendEmailClass.showEmails();
        for (String data : dates){
            showEmails.setText(data);
        }

        hbox.setAlignment(Pos.TOP_CENTER);
        HBox.setMargin(showEmails,new Insets(20,0,0,0));
        hbox.getChildren().add(showEmails);
        return hbox;
    }

    @Override
    public VBox separator(VBox vboxSeparator) {
        VBox mainSeparator = super.separator(vboxSeparator);
        VBox.setMargin(separator, new Insets(70, 0, 0, 0));
        return mainSeparator;
    }

    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        save.setOnAction(e->{
            if(fileSetSendEmailClass.writeEmailToFile(showEmails.getText())){
                edit(alert);
            } else {
                errorField(alert);
            }
        });
        HBox mainButtonBox = super.buttonPartOfWindow(hbox);
        HBox.setMargin(cancel,new Insets(10,10,12,0));
        HBox.setMargin(save,new Insets(10,10,12,10));
        return mainButtonBox;
    }
}