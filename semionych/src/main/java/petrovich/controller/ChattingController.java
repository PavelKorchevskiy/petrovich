package petrovich.controller;

import petrovich.dto.Message;
import petrovich.service.MessageGenerationService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chat/")
@Api
@Slf4j
public class ChattingController {

    private MessageGenerationService messageGenerationService;

    @GetMapping("message")
    public String listen(@RequestBody String message) {
        log.info("Someone sent the message - {}", message);
        return messageGenerationService.answer(message);
    }

    @PostMapping("/message")
    public String listen(@RequestBody Message message) {
        return messageGenerationService.answer(message);
    }

    @Autowired
    public ChattingController(MessageGenerationService messageGenerationService) {
        this.messageGenerationService = messageGenerationService;
    }
}
