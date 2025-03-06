package linguosmart.domain.enums;

import jakarta.persistence.AttributeConverter;

public interface JpaEnumConverter<E extends Enum<E> & PersistableEnum<T>, T> extends AttributeConverter<E, T> {

    public abstract Class<E> getEnumClass();

    @Override
    public default T convertToDatabaseColumn(E persistableEnum) {
        return persistableEnum == null ? null : persistableEnum.ofCode();
    }

    @Override
    public default E convertToEntityAttribute(T dbData) {
        return PersistableEnum.fromCode(getEnumClass(), dbData);
    }

}
