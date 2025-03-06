package linguosmart.domain.enums;

import jakarta.persistence.Converter;

public enum QuestionType implements PersistableEnum<String>{
    MULTIPLE_CHOICE("MC"), TRUE_FALSE("TF"), SHORT_ANSWER("SA"), ESSAY("ESSAY");

    private final String questionType;

    QuestionType(String questionType) {
        this.questionType = questionType;
    }

    @Override
    public String ofCode() {
        return this.questionType;
    }

    @Converter(autoApply = true)
    public static class TransportModeConverter implements JpaEnumConverter<QuestionType, String> {
        @Override
        public Class<QuestionType> getEnumClass() {
            return QuestionType.class;
        }
    }

}
