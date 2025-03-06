package linguosmart.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@UtilityClass
public final class DateUtils {
    public static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_NUMBER8 = "yyyyMMdd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATETIME_FORMAT_WITHOUT_SECOND = "yyyy-MM-dd'T'HH:mm";
    public static final String DATETIME_FORMAT_WITHOUT_T = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_LONG = "yyyyMMddHHmmss";
    public static final String TIME_FORMAT_SHORT = "HHmm";

    private static final ZoneId SystemZone = ZoneId.of("Asia/Hong_Kong");

    public static LocalDate convertDateStrToLocalDate(String dateStr, String format) {
        return StringUtils.isNotBlank(dateStr) ? LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(format)) : null;
    }

    public static LocalDate convertDateStrToLocalDate(String dateStr) {
        return StringUtils.isNotBlank(dateStr) ? LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DEFAULT_DATEFORMAT)) : null;
    }

    public static LocalDateTime convertDateStrToLocalDateTime(String dateStr, String format) {
        return StringUtils.isNotBlank(dateStr) ? LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(format)) : null;
    }

    public static LocalDateTime convertDateStrToLocalDateTime(String dateStr) {
        return StringUtils.isNotBlank(dateStr) ? LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(DEFAULT_DATEFORMAT)) : null;
    }

    public static long convertLocalDateTimeToLong(LocalDateTime localDateTime) {
        return localDateTime.atZone(SystemZone).toInstant().toEpochMilli();
    }

    public static LocalDateTime convertEpochMilliToLocalDateTime(long epochMilli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), SystemZone);
    }

    public static String formatDate(LocalDate localDateTime, String pattern) {
        return localDateTime != null ? localDateTime.format(DateTimeFormatter.ofPattern(pattern)) : null;
    }

    public static String formatDateTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime != null ? localDateTime.format(DateTimeFormatter.ofPattern(pattern)) : null;
    }

    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert != null ? Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(SystemZone)
                .toLocalDateTime() : null;
    }

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert != null ? Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(SystemZone)
                .toLocalDate() : null;
    }
}
