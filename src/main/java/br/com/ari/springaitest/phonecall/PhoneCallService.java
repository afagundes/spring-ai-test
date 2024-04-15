package br.com.ari.springaitest.phonecall;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.stereotype.Service;

@Service
public class PhoneCallService {

    private final ChatClient chatClient;

    public PhoneCallService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public PhoneCallDto categorize(String transcript) {
        BeanOutputParser<PhoneCallDto> phoneCallDtoBeanOutputParser = new BeanOutputParser<>(PhoneCallDto.class);

        String promptString = """
                You work in the telephone exchange of a large bank. Your job is to receive the transcript of the calls
                and assign them a title and one or more categories based on the subject of the calls.
                The transcriptions are in Brazilian Portuguese. The titles and categories you define must also be in Brazilian Portuguese.
                Categorize the following transcript:
                {transcript}
                {format}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(promptString);
        promptTemplate.add("transcript", transcript);
        promptTemplate.add("format", phoneCallDtoBeanOutputParser.getFormat());
        promptTemplate.setOutputParser(phoneCallDtoBeanOutputParser);

        ChatResponse response = chatClient.call(promptTemplate.create());
        System.out.println(response);
        System.out.println(response.getMetadata());
        System.out.println(response.getResult().getOutput());

        return phoneCallDtoBeanOutputParser.parse(response.getResult().getOutput().getContent());
    }

}
