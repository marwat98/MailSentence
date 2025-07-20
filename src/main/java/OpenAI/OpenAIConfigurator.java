package OpenAI;

import Interfaces.OpenAIInterface;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;


public class OpenAIConfigurator implements OpenAIInterface {

    /**
     * method contain settings which generate message
     * @param text is instruction for GPT
     * @return String with answer
     */
    @Override
    public String generate(String text){
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage(text)
                .model(ChatModel.GPT_4_1)
                .build();
        ChatCompletion chatCompletion = client.chat().completions().create(params);
        String response = chatCompletion.choices().getFirst().message().content().orElse("Something is wrong try again");

        return response;

    }


}
