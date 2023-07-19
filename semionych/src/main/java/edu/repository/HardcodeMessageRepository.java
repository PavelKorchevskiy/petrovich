package edu.repository;

import org.springframework.stereotype.Repository;
import edu.util.CollectionUtils;

import java.util.List;

@Repository
public class HardcodeMessageRepository implements MessageRepository {

    private static final List<String> welcomeMessages = List.of("hi", "hello");

    @Override
    public String getRandomMessage() {
        return CollectionUtils.getRandomElementFromList(getAllMessages());
    }

    @Override
    public String getMessageByIncomingMessage(String incomingMessage) {
        if (getWelcomeMessages().contains(incomingMessage)) {
            return CollectionUtils.getRandomElementFromList(getWelcomeMessages());
        }
        return getRandomMessage();
    }

    @Override
    public List<String> getAllMessages() {
        return List.of("Kurwa", "Ja pierdole", "Chuj go wie");
    }

    public static List<String> getWelcomeMessages() {
        return welcomeMessages;
    }
}
