package JavaFXClass;

import Interfaces.SetYourEmailWindowInterface;
import com.sun.mail.imap.protocol.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Date;

public class SetYourEmailClass implements SetYourEmailWindowInterface {


    @Override
    public HBox topPartOfSetYourEmailWindow(HBox hbox ) {
        Label label = new Label("Write your email:");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        TextField email = new TextField();
        email.setPrefSize(200,20);
        Button save = new Button("Save");
        save.setPrefSize(100,20);
        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(label,new Insets(2,0,0,15));
        hbox.getChildren().addAll(label,email,save);
        return hbox;
    }

    @Override
    public VBox middlePartOfSetYourEmailWindow(VBox vbox) {
        TableView<Item> emailsTable = new TableView<>();
        emailsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        vbox.setVgrow(emailsTable,Priority.ALWAYS);
        TableColumn<Item,String> emailCol = new TableColumn<>("Email");
        TableColumn<Item, Date> dateCol = new TableColumn<>("Date");
        emailsTable.getColumns().addAll(emailCol,dateCol);
        return vbox;
    }

    @Override
    public VBox buttonPartOfSetYourEmailWindow(Button cancel, Button save) {
        return null;
    }
}
