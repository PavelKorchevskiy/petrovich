package petrovich.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@Slf4j
@ConditionalOnProperty(prefix = "kafka", name = "enable")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic-name}")
    private String topicName;

    @PostMapping("message")
    public void sendMessage(String msgId, String msg){
        kafkaTemplate.send(topicName, msgId, msg);
        log.info("Message {} was send to topic {}", msg, topicName);
    }
}
