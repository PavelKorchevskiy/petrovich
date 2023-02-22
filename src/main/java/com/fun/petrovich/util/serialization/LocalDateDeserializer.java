package com.fun.petrovich.util.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.concurrent.ConcurrentHashMap;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

//    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter df1 = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(df)
            .appendOffset("+H:MM", "+3:00")
            .parseStrict()
            .toFormatter();
    private static final DateTimeFormatter dfGMT = DateTimeFormatter.ofPattern("yyyy-MM-ddz");

    private final DateTimeFormatter[] formatters = {
            df,
            df1,
            dfGMT
    };

    private static final ConcurrentHashMap<String, DateTimeFormatter> formattersMap = new ConcurrentHashMap<>();

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = parser.getValueAsString();

        if (value == null || value.length() == 0 || (value = value.trim()).length() == 0)
            return null;

        DateTimeFormatter current = formattersMap.get(parser.currentName());
        DateTimeParseException lastError = null;

        if (current != null) {
            try {
                return LocalDate.from(current.parse(value));
            } catch (DateTimeParseException e) {
                lastError = e;
            }
        }

        for (DateTimeFormatter df : formatters)
            if (df != current)
                try {
                    LocalDate result = LocalDate.from(df.parse(value));
                    formattersMap.put(parser.currentName(), df);

                    return result;
                } catch (DateTimeParseException e) {
                    lastError = e;
                }

        if (lastError == null)
            throw new IllegalStateException("Parsers is empty");

        throw lastError;
    }

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }
}
