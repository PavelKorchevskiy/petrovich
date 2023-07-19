package edu.service;

import edu.dto.Message;

public interface MessageGenerationService {

    String answer(String message);

    String answer(Message message);
}
