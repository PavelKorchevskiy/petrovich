package service.service;

import service.dto.Message;

public interface MessageGenerationService {

    String answer(String message);

    String answer(Message message);
}
