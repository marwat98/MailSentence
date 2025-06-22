package JavaFXClass;

import Interfaces.ButtonManagerInterface;
import javafx.scene.control.Button;

public class ButtonManager implements ButtonManagerInterface {

    @Override
    public Button setButtonSize(String text) {
        Button buttonJavaFX = new Button(text);
        buttonJavaFX.setPrefSize(200, 40);
        return buttonJavaFX;
    }
}
