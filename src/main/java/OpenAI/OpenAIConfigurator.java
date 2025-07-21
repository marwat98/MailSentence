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
     * method contains settings which generate title to post emails
     * @param text is instruction for GPT
     * @return String with answer
     */
    @Override
    public String generate(String text, String apiKey){
        if ((text == null || text.isEmpty()) || (apiKey == null || apiKey.isEmpty())) {
            throw new IllegalArgumentException("Text or API key cannot be null or empty");
        }
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage(text)
                .model(ChatModel.GPT_4_1)
                .build();
        try{
            ChatCompletion chatCompletion = client.chat().completions().create(params);
            String response = chatCompletion.choices().getFirst().message().content().orElse("Something is wrong try again");
            return response;
        } catch(Exception e) {
            throw new RuntimeException("OpenAI request failed: " + e.getMessage());
        }
    }
}
