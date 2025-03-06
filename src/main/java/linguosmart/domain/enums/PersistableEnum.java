package linguosmart.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public interface PersistableEnum<T> {

    @JsonValue
    T ofCode();

    public static <E extends Enum<E> & PersistableEnum<T>, T> E fromCode(Class<E> clazz, T code) {
        return Stream.of(clazz.getEnumConstants())
                .filter(e -> e.ofCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
