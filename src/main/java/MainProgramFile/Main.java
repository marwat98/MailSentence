package MainProgramFile;

import AbstractClass.FileWriter;
import FileWriterClass.FileWriterClass;
import GmailSendMessage.GmailSend;
import InformationClass.Sentences;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sentences showSentence = new Sentences();
        EmailValidator email = EmailValidator.getInstance();
        File myEmailFile = new File("src/main/java/ProgramFiles/myEmailFile.txt");
        int choose;


        showSentence.mainSentence("");
        showSentence.mainSentence("-------Mail_Sentence_Program-------");
        showSentence.mainSentence("Menu");
        showSentence.mainSentence("1.Set email send");
        showSentence.mainSentence("2.Set email call");
        showSentence.mainSentence("-----------------------------------");
        System.out.print("Choose: ");
        choose = scanner.nextInt();

        switch(choose){
            case 1 ->{
                   showSentence.mainSentence("-----------------------------------");
                   showSentence.mainSentence(" Choose option in your email file  ");
                   showSentence.mainSentence("-----------------------------------");
                   showSentence.mainSentence("1. Write your email");
                   showSentence.mainSentence("2. Show your email file");
                   showSentence.mainSentence("-----------------------------------");
                   System.out.print("Choose: ");
                   choose = scanner.nextInt();

                   if(choose == 1){
                       FileWriterClass fileWriter = new FileWriterClass(myEmailFile);
                       String writeEmail = scanner.next();
                       String checkWriteEmail = (email.isValid(writeEmail)) ? "Sucess!! Your email is right" : "You write wrong email try again";
                       System.out.println(checkWriteEmail);
                       fileWriter.writeEmailInFile(writeEmail);
                   } else {
                       System.out.println("Show your email file");
                   }
            }
            case 2 ->{

            }
        }

        GmailSend gmail = new GmailSend("yourmail@gmail.com","sendmail@gmail.com","hostAdress","appPassword");












    }
}
