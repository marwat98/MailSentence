package JavaFXClass;

import Interfaces.WindowViewInterface;
import MainProgramFile.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.util.Date;

public class SetYourEmail implements WindowViewInterface {

    /**
     * method builds and return top part of the email settings view
     * @param hbox to which UI components will be added
     * @return hbox containing (Label , TextField , Button)
     */
    @Override
    public HBox topPartOfSetYourEmailWindow(HBox hbox ) {
        Label label = new Label("Write your email:");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));

        TextField email = new TextField();
        email.setPrefSize(200,20);

        Button save = new Button("Save");
        save.setPrefSize(100,20);

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(label,new Insets(2,0,0,35));
        hbox.getChildren().addAll(label,email,save);

        return hbox;
    }

    /**
     * method builds and return middle part of the email settings view
     * @param vbox to UI compontents will be view
     * @return vbox containing (TableView , TableColumn )
     */
    @Override
    public VBox middlePartOfSetYourEmailWindow(VBox vbox) {
         TableView<TableEmail> tableEmail = new TableView<>();
         tableEmail.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

         VBox.setVgrow(tableEmail, Priority.ALWAYS);

         TableColumn<TableEmail,Integer> colID = new TableColumn<>("id");
         TableColumn<TableEmail,String> colEmail = new TableColumn<>("Email");
         TableColumn<TableEmail, Date> colDate = new TableColumn<>("Date");

         colID.setCellValueFactory(new PropertyValueFactory<>("id"));
         colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
         colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

         tableEmail.getColumns().addAll(
                 colID,colEmail,colDate
         );

         vbox.setAlignment(Pos.CENTER);
         VBox.setMargin(tableEmail, new Insets(35));
         vbox.getChildren().add(tableEmail);

         return vbox;
    }

    /**
     * method builds and return button part of the email settings view
     * @param hbox to UI buttons
     * @return hbox containg buttons
     */
    @Override
    public HBox buttonPartOfSetYourEmailWindow(HBox hbox) {
        ButtonManager button = new ButtonManager();
        Button cancel = button.setButtonSize("Cancel",100, 20);
        Button edit = button.setButtonSize("Edit",100, 20);

        cancel.setOnAction( e->{
            Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
            currentlyWindow.close();

            try {
                new Main().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        edit.setOnAction(e->{

        });

        hbox.setAlignment(Pos.BOTTOM_LEFT);
        HBox.setMargin(cancel,new Insets(0,0,3,35));
        HBox.setMargin(edit,new Insets(0,0,3,10));
        hbox.getChildren().addAll(cancel,edit);

        return hbox;
    }
}
