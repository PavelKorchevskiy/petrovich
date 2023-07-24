package edu.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@ConditionalOnProperty(prefix = "kafka", name = "enable")
public class KafkaConsumer {

    @Value("${kafka.topic-name}")
    private String topicName;

    @KafkaListener(topics =  {"#{'topicName'}"}, groupId = "2")
    public void msgListener(String msg){
        log.info("Message {} was read from topic {}", msg, topicName);
    }
}
