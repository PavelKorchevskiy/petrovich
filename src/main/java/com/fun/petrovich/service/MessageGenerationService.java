package com.fun.petrovich.service;

import com.fun.petrovich.dto.Message;

public interface MessageGenerationService {

    String answer(String message);

    String answer(Message message);
}
