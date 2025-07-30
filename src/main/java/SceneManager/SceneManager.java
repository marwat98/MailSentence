package SceneManager;

import AbstractClasses.SceneSettingsClass;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneManager extends SceneSettingsClass {

    public SceneManager(Stage stage) {
        super(stage);
    }

    /**
     * Displays the current scene in the application window (Stage).
     */
    @Override
    public void openPanel(Scene scene , String text) {
        stage.setTitle(text);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates a JavaFX Scene using a given layout and dimensions.
     *
     * @param layout   layout container (StackPane) holding all scene elements
     * @param width  width of the application window
     * @param height height of the application window
     * @return created Scene instance
     */
    @Override
    public Scene scenePanel(VBox layout, int width, int height) {
        return new Scene(layout, width, height);
    }

}
