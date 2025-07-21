package Alert;

import Interfaces.AlertInterface;
import javafx.scene.control.Alert;

public class AlertClass implements AlertInterface {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void alertMessage( String title, String content) {
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
