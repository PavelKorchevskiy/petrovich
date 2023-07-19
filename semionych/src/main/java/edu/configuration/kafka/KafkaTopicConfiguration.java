package edu.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Value("${kafka.topic-name}")
    private String topicName;

    @Bean
    @ConditionalOnProperty(prefix = "kafka", name = "enable")
    public NewTopic topicExample() {
        return TopicBuilder.name(topicName)
                .partitions(2)
                .replicas(1)
                .build();
    }
}
