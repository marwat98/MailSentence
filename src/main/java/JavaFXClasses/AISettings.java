package JavaFXClasses;

import ProgramFileClasses.FileOpenAIClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AISettings extends Settings{
    private static final Path PROMPT_TITLE_AI = Paths.get(MAIN_PACKAGE_FILES,"promptTitleAIFile.txt");
    private static final Path PROMPT_DESCRIPTION_AI = Paths.get(MAIN_PACKAGE_FILES,"promptDescriptionAIFile.txt");

    public File titleAIFile = new File(String.valueOf(PROMPT_TITLE_AI));
    public File descriptionAIFile = new File(String.valueOf(PROMPT_DESCRIPTION_AI));

    public FileOpenAIClass titileAISave = new FileOpenAIClass(titleAIFile.toPath());
    public FileOpenAIClass descriptionAISave = new FileOpenAIClass(descriptionAIFile.toPath());

    public TextArea promptTitleAIField = new TextArea();
    public TextArea promptDescriptionAIField = new TextArea();

    @Override
    public HBox title(HBox hbox, String labelText) {
        return super.title(hbox, labelText);
    }

    @Override
    public VBox inputPartOfWindow(VBox vbox) {
        // Label and TextArea for Title AI and read file function
        Label promptTitleAILabel = new Label("Title AI");
        promptTitleAILabel.setFont(Font.font(15));
        promptTitleAIField.setPrefSize(530,50);

        //Show content prompt title file
        String titleAI = titileAISave.readFile(titleAIFile);
        promptTitleAIField.setText(titleAI);

        HBox promptTitleAIHBox = new HBox();
        promptTitleAIHBox.setAlignment(Pos.TOP_LEFT);
        promptTitleAIHBox.getChildren().addAll(promptTitleAILabel,promptTitleAIField);
        HBox.setMargin(promptTitleAILabel,new Insets(70,70,0,10));
        HBox.setMargin(promptTitleAIField,new Insets(60,0,0,10));

        //Label and TextField for Description AI and read file function
        Label promptDescriptionAILabel = new Label("Description AI");
        promptDescriptionAILabel.setFont(Font.font(15));
        promptDescriptionAIField.setPrefSize(530,50);

        // Show content prompt description file
        String descriptionAI = descriptionAISave.readFile(descriptionAIFile);
        promptDescriptionAIField.setText(descriptionAI);

        HBox promptDescriptionAIHBox = new HBox();
        promptDescriptionAIHBox.setAlignment(Pos.TOP_LEFT);
        promptDescriptionAIHBox.getChildren().addAll(promptDescriptionAILabel, promptDescriptionAIField);
        HBox.setMargin(promptDescriptionAILabel,new Insets(30,25,0,10));
        HBox.setMargin(promptDescriptionAIField,new Insets(20,0,0,10));

        vbox.getChildren().addAll(promptTitleAIHBox, promptDescriptionAIHBox);

        return vbox;
    }

    @Override
    public VBox separator(VBox vboxSeparator) {
        return super.separator(vboxSeparator);
    }

    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        HBox mainButton = super.buttonPartOfWindow(hbox);

        // Action which save AI settings
        save.setOnAction(e->{
            String checkTitleAI = promptTitleAIField.getText().trim();
            String checkDescriptionAI = promptDescriptionAIField.getText().trim();

            if(checkTitleAI.isEmpty()){
                alert.alertMessage("Empty field!", "❌ Your Title AI field is empty");
                return;
            }
            if(checkDescriptionAI.isEmpty()){
                alert.alertMessage("Empty field!", "❌ Your Description AI field is empty");
                return;
            }
            boolean title = titileAISave.writeToFile(checkTitleAI);
            boolean description = descriptionAISave.writeToFile(checkDescriptionAI);

            if(title && description){
                alert.alertMessage("Succes","✅ Settings are saving");
            }
        });

        return mainButton;
    }
}
