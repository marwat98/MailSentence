package AbstractClass;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public abstract class SceneSettingsClass {
    protected Stage stage;

    public SceneSettingsClass(Stage stage){
        this.stage = stage;
    }
    public abstract void openPanel(Scene scene , String text);
    public abstract Scene scenePanel(StackPane pane,int width, int height);
}
