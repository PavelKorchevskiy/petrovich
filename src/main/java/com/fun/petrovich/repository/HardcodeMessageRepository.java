package com.fun.petrovich.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fun.petrovich.util.CollectionUtils.getRandomElementFromList;

@Repository
public class HardcodeMessageRepository implements MessageRepository {

    private static final List<String> welcomeMessages = List.of("hi", "hello");

    @Override
    public String getRandomMessage() {
        return getRandomElementFromList(getAllMessages());
    }

    @Override
    public String getMessageByIncomingMessage(String incomingMessage) {
        if (getWelcomeMessages().contains(incomingMessage)) {
            return getRandomElementFromList(getWelcomeMessages());
        }
        return null;
    }

    @Override
    public List<String> getAllMessages() {
        return List.of("Kurwa", "Ja pierdole", "Chuj go wie");
    }

    public static List<String> getWelcomeMessages() {
        return welcomeMessages;
    }
}
