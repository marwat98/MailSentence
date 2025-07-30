package SetEmail;

import FileManagerClasses.FileManagerClass;
import FileManagerClasses.FileManagerOpenAIClass;
import Interfaces.SaveSetEmailSettingsInterface;
import RefreshWindow.RefreshWindow;
import javafx.scene.control.TextField;
import Alert.AlertClass;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static SetEmail.SetEmail.MAIN_PACKAGE_FILES;

public class SaveSetEmailSettings implements SaveSetEmailSettingsInterface {
    /**
     *
     * @param fromSetEmail field which set your email
     * @param title field which set title your email
     * @param alert method that show alerts
     * @param refresh method that refresh pole after saving settings
     */
    @Override
    public void save(TextField fromSetEmail, TextField title, AlertClass alert, RefreshWindow refresh) {

        final Path FROM_PATH = Paths.get(MAIN_PACKAGE_FILES , "myEmailFile.txt");
        final Path TITLE_PATH = Paths.get(MAIN_PACKAGE_FILES , "emailTitleFile.txt");

        File titleFile = new File(String.valueOf(TITLE_PATH));
        File myEmailFile = new File(String.valueOf(FROM_PATH));

        FileManagerClass fileSetYourEmailClass = new FileManagerClass(myEmailFile.toPath());
        FileManagerOpenAIClass saveTitleOpenAI = new FileManagerOpenAIClass(titleFile.toPath());

        boolean fromSaveToFile = fileSetYourEmailClass.writeToFile(fromSetEmail.getText());
        boolean toSaveTitleToFile = saveTitleOpenAI.writeToFile(title.getText());


        if(fromSaveToFile){
            alert.alertMessage("Success", "✅ You save email");
            refresh.refreshWindow(fromSetEmail,FROM_PATH);
        } else {
            alert.alertMessage("Fail!","❌ Saving email in file failing");
        }
        if (toSaveTitleToFile) {
            alert.alertMessage("Success", "✅ You save title");
            refresh.refreshWindow(title,TITLE_PATH);
        } else {
            alert.alertMessage("Fail!","❌ Saving title in file failing");
        }
    }
}
