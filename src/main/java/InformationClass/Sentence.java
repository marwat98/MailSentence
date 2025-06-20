package InformationClass;


import Interfaces.SentenceInterface;


public class Sentence implements SentenceInterface {
    /**
     * Displays a message in the console and returns it.
     *
     * @param text the message to display
     * @return the same message that was displayed
     */
    @Override
    public String show(String text) {
        System.out.print(text);
        return text;
    }

    /**
     * Display Menu in the console
     * @return String message inside the method
     */
    @Override
    public String printMenu() {
        return """
           ------- Mail_Sentence_Program -------
           Menu:
           1. Set email send
           2. Set email call
           -------------------------------------
           """;
    }
    /**
     * Display Choose one option in the console
     * @return String text choose one option menu
     */
    @Override
    public String printChooseOne() {
        return """
                "-----------------------------------"
                " Choose option in your email file  "
                "-----------------------------------"
                "1. Write your email"
                "2. Show your email file"
                "-----------------------------------"
                """;
    }
}
