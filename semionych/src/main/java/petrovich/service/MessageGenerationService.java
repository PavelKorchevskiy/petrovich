package petrovich.service;

import petrovich.dto.Message;

public interface MessageGenerationService {

    String answer(String message);

    String answer(Message message);
}
