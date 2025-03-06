package linguosmart.utils;

import org.apache.commons.lang3.StringUtils;

import lombok.experimental.UtilityClass;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class ValidateUtils {

    public static boolean isValidCharacter(String data) {
        if (StringUtils.isBlank(data) || StringUtils.isEmpty(data)) {
            return true;
        }

        //The character is not a Traditional Chinese, Simplified Chinese ,alpha , numeric, European or Russian
//        if (ChineseUtils.isChineseAlphaNumeric(data)) {
//            return true;
//        }

        if (isEuropean(data) || isRussian(data)) {
            return true;
        }

        return false;
    }

    public static boolean isValidDateRange(LocalDate from, LocalDate to, int validDayRange) {
        if (from == null || to == null) {
            return false;
        }

        if (to.isBefore(from)) {
            return false;
        }

        // Add one day because same from and to should count as one day
        long diff = ChronoUnit.DAYS.between(from, to.plusDays(1));
        return diff <= validDayRange;
    }

    public static boolean isValidDateRange(LocalDateTime from, LocalDateTime to, int validDayRange) {
        if (from == null || to == null) {
            return false;
        }

        if (to.isBefore(from)) {
            return false;
        }
        return Duration.between(from, to).compareTo(Duration.ofDays(validDayRange)) <= 0;
    }

    private static boolean isEuropean(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (data.codePointAt(i) > 255) {
                return false;
            }
        }
        return true;

    }

    /**
     * Check the string is Russian or not.Treat as valid with null string.
     *
     * @param data
     * @return
     */
    private static boolean isRussian(String data) {
        for (int i = 0; i < data.length(); i++) {
            int codePoint = data.codePointAt(i);

            if (codePoint > 255 && (codePoint < 1024 || codePoint > 1280)) {
                return false;
            }
        }
        return true;
    }

}
