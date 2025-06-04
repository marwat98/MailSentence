package srcMailSentence;

import InformationClass.Sentences;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sentences showSentence = new Sentences();
        EmailValidator email = EmailValidator.getInstance();

        showSentence.mainSentence("-------Mail_Sentence_Program-------");
        showSentence.mainSentence("1.Wpisz email: ");
        String input = scanner.nextLine();

        if(email.isValid(input)){
            showSentence.mainSentence("Czy wygenerować wiadomość");
        } else {
            showSentence.mainSentence("Podany tekst nie jest mailem");

        }










    }
}
