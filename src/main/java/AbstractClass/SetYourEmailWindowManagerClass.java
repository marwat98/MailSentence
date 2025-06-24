package AbstractClass;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class SetYourEmailWindowManagerClass {
    protected VBox vbox;
    protected HBox hbox;

    public SetYourEmailWindowManagerClass(VBox vbox , HBox hbox){
        this.vbox = vbox;
        this.hbox = hbox;
    }
    public abstract VBox topPartOfSetYourEmailWindow(Label label , TextField email);
    public abstract VBox middlePartOfSetYourEmailWindow(TableView tableView , TableColumn column , Separator seprarator);
    public abstract VBox buttonPartOfSetYourEmailWindow(Button cancel, Button save);
}
