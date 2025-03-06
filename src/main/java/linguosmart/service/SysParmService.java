package linguosmart.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@Transactional
public class SysParmService {

    private static final String DATETIME_PATTERN_YYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    private static final String DATETIME_PATTERN_YYMMDD = "yyyy-MM-dd";
    private static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN_YYMMDDHHMMSS);
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN_YYMMDD);


}
