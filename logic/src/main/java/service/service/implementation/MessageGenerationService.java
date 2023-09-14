package service.service.implementation;

import service.dto.Message;
import service.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageGenerationService implements service.service.MessageGenerationService {

    private MessageRepository messageRepository;
    @Override
    public String answer(String incomingMessage) {
        return messageRepository.getMessageByIncomingMessage(incomingMessage);
    }

    @Override
    public String answer(Message incomingMessage) {
        log.info("Message date - " + incomingMessage.getDate());
        return messageRepository.getRandomMessage();
    }

    @Autowired
    public MessageGenerationService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
