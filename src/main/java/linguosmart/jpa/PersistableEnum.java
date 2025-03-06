package linguosmart.jpa;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonValue;

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
