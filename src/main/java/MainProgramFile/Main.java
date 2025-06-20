package MainProgramFile;

import FileClass.FileClass;
import GmailSendMessage.GmailSend;
import InformationClass.Sentence;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sentence showSentence = new Sentence();
        EmailValidator email = EmailValidator.getInstance();
        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
        FileClass file = new FileClass(myEmailFile);
        int choose;


        showSentence.printMenu();
        showSentence.show("Choose: ");
        choose = scanner.nextInt();

        switch(choose){
            case 1 ->{
                showSentence.printChooseOne();
                showSentence.show("Choose: ");
                choose = scanner.nextInt();

                if(choose == 1){
                    String writeEmail = scanner.next();
                    String checkWriteEmail = (email.isValid(writeEmail)) ? "Sucess!! Your email is right" : "You write wrong email try again";
                    System.out.println(checkWriteEmail);
                    file.writeEmailInFile(writeEmail);
                } else {
                    try {
                        file.showEmails();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            case 2 ->{

            }
        }

        GmailSend gmail = new GmailSend("yourmail@gmail.com","sendmail@gmail.com","hostAdress","appPassword");

    }
}
