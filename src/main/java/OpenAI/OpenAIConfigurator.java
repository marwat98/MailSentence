package OpenAI;

import Interfaces.OpenAIInterface;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class OpenAIConfigurator implements OpenAIInterface {

    /**
     * method contain settings which generate message
     * @param text is instruction for GPT
     * @return String with answer
     */
    @Override
    public String generate(String text, String apiKey){
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage(text)
                .model(ChatModel.GPT_4_1)
                .build();
        ChatCompletion chatCompletion = client.chat().completions().create(params);
        String response = chatCompletion.choices().getFirst().message().content().orElse("Something is wrong try again");

        return response;

    }
    @Override
    public String readAPIKey(File apiFile){
        try(Scanner readFile = new Scanner(apiFile)){
            if(readFile.hasNextLine()){
                return readFile.nextLine().trim();
            } else {
                throw new IllegalStateException("File havent open AI Key");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
