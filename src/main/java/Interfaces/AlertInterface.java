package Interfaces;

import javafx.scene.control.Alert;

public interface AlertInterface {
    default void sucess(Alert alert){
        alert.setTitle("Succes");
        alert.setHeaderText(null);
        alert.setContentText("You save email");
        alert.showAndWait();
    }
    default void emptyField(Alert alert){
        alert.setTitle("Empty Field Error");
        alert.setHeaderText(null);
        alert.setContentText("Field can't be empty");
        alert.showAndWait();
    }
    default void errorField(Alert alert){
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("This text isn't email address");
        alert.showAndWait();
    }
    default void edit(Alert alert){
        alert.setTitle("Edit field");
        alert.setHeaderText(null);
        alert.setContentText("Succesful edit field");
        alert.showAndWait();
    }
}
