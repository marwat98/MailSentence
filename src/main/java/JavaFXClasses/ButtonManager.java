package JavaFXClasses;

import Interfaces.ButtonManagerInterface;
import javafx.scene.control.Button;

public class ButtonManager implements ButtonManagerInterface {

    @Override
    public Button setButtonSize(String text, int width , int height) {
        Button buttonJavaFX = new Button(text);
        buttonJavaFX.setPrefSize(width,height);
        return buttonJavaFX;
    }
}
