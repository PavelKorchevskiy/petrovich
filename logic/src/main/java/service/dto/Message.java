package service.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import service.util.serialization.LocalDateDeserializer;
import service.util.serialization.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Message {

    private String info;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
}
