package AbstractClasses;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class SceneSettingsClass {
    protected Stage stage;

    public SceneSettingsClass(Stage stage){
        this.stage = stage;
    }
    public abstract void openPanel(Scene scene , String text);
    public abstract Scene scenePanel(VBox layout, int width, int height);
}
