package JavaFXClass;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SetSendEmail extends SetYourEmail{
    @Override
    public HBox title(HBox hbox,String labelText) {
        return super.title(hbox,labelText);
    }

    @Override
    public HBox topPartOfWindow(HBox hbox) {
        return super.topPartOfWindow(hbox);
    }

    @Override
    public VBox separator(VBox vboxSeparator) {
        return super.separator(vboxSeparator);
    }

    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        return super.buttonPartOfWindow(hbox);
    }
}
