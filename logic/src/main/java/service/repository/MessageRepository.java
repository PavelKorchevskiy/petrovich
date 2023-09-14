package service.repository;

import java.util.List;

public interface MessageRepository {

    public String getRandomMessage();

    public String getMessageByIncomingMessage(String incomingMessage);

    public List<String> getAllMessages();
}
