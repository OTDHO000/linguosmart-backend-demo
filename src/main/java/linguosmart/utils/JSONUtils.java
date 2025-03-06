package linguosmart.utils;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class JSONUtils {
    private static ObjectMapper myObjectMapper = null;

    static {
        myObjectMapper = new ObjectMapper();
        myObjectMapper
                //              .configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
                .registerModule(new JavaTimeModule());
    }

    public static <T> Optional<T> fromJSON(String json, Class<T> clazz) {
        try {
            return Optional.ofNullable(myObjectMapper.readValue(json, clazz));
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize JSON Data", e.getMessage());
        }

        return Optional.empty();
    }

    public static String toJSON(Object o) {
        String json = "";
        try {
            json = myObjectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("toJSON", e);
        }

        return json;
    }

}
