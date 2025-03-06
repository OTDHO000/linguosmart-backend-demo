package linguosmart.service;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
public class SessionService {

    private static final String UNKNOWN = "Unknown";
    private static final String KEY_SYS_MAX_CONCUR_SESS = "SYS_MAX_CONCUR_SESS";

    private static final String UPDATE_SESS_SQL = """
            UPDATE SESS
            SET
                LAST_ACCESS_DT = :lastAccessDt
            WHERE
                USER_ID = :userId
                AND SESS_ID = :sessId
            """;

    private static final String REMOVE_SESS_SQL = """
            DELETE FROM SESS
            WHERE
                USER_ID = :userId
                AND SESS_ID = :sessId
            """;

    private static final String BATCH_REMOVE_SESS_SQL = """
            DELETE FROM SESS
            WHERE
                REC_ID IN (:recIds)
            """;


    @Autowired
    SysParmService sysParmService;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

//    public void recordNewSess(String sessionId) {
//        if (SecurityContextHolder.getSecurityContext().isEmpty()) {
//            throw new AppInvalidException(ErrorConstants.CODE_UNEXPECTED_SYSTEM_ERROR);
//        }
//        SecurityContext sctx = SecurityContextHolder.getSecurityContext().get();
//        // Remove the oldest session if more than max number of sessions allowed
//        int maxConcurSess = sysParmService.getNumberSysParm(KEY_SYS_MAX_CONCUR_SESS).intValue();
//        List<Sess> existingSession = sessRepository.findByUserIdOrderByLastAccessDt(sctx.getUser().getRecId());
//
//        // Remove the oldest session if more than max number of sessions allowed
//        List<Long> toRemove = existingSession.subList(0, Math.clamp(existingSession.size() - (long) maxConcurSess, 0, Integer.MAX_VALUE)).stream().map(Sess::getRecId).toList();
//        if (!toRemove.isEmpty()) {
//            MapSqlParameterSource batchRemoveParameter = new MapSqlParameterSource("recIds", toRemove);
//            jdbcTemplate.update(BATCH_REMOVE_SESS_SQL, batchRemoveParameter);
//        }
//
//        sessRepository.save(Sess.builder()
//                .userId(sctx.getUser().getRecId())
//                .sessId(sessionId)
//                .siteId("3") // TODO: update to resolve from server
//                .lastAccessDt(LocalDateTime.now())
//                .build()
//        );
//    }
//
//    public void updateSessTime(String sessionId) {
//        if (SecurityContextHolder.getSecurityContext().isEmpty()) {
//            throw new AppInvalidException(ErrorConstants.CODE_UNEXPECTED_SYSTEM_ERROR);
//        }
//
//        SecurityContext sctx = SecurityContextHolder.getSecurityContext().get();
//
//        int result = jdbcTemplate.update(UPDATE_SESS_SQL,
//                new MapSqlParameterSource()
//                        .addValue("lastAccessDt", LocalDateTime.now())
//                        .addValue("sessId", sessionId)
//                        .addValue("userId", sctx.getUser().getRecId())
//        );
//        if (result == 0) {
//            SecurityContextHolder.invalidateUserSession();
//            throw new AppInvalidException(ErrorConstants.CODE_INVALID_SESSION);
//        }
//    }
//
//    public void removeSess(String sessionId) {
//        if (SecurityContextHolder.getSecurityContext().isEmpty()) {
//            throw new AppInvalidException(ErrorConstants.CODE_UNEXPECTED_SYSTEM_ERROR);
//        }
//        SecurityContext sctx = SecurityContextHolder.getSecurityContext().get();
//        jdbcTemplate.update(REMOVE_SESS_SQL, new MapSqlParameterSource()
//                        .addValue("sessId", sessionId)
//                        .addValue("userId", sctx.getUser().getRecId())
//        );
//    }
//
//    public void recordLoginLogoutActivity(LoginLogoutRecord loginLogoutRecord) {
//        String dept = UNKNOWN;
//        // In case userUid is null
//        String userUid = loginLogoutRecord.getUserUid() == null ? UNKNOWN : loginLogoutRecord.getUserUid();
//        Long wkstnId = null;
//
//        if (SecurityContextHolder.getSecurityContext().isPresent()) {
//            SecurityContext sctx = SecurityContextHolder.getSecurityContext().get();
//            User user = sctx.getUser();
//            if (user != null) {
//                userUid = user.getUid();
//                dept = user.getDept();
//            }
//            Wkstn wkstn = sctx.getCurrentWkstn();
//            if (wkstn != null) {
//                wkstnId = wkstn.getRecId();
//            }
//        }
//
//        sessActvLogRepository.save(SessActvLog.builder()
//                .dept(dept)
//                .uid(userUid)
//                .type(loginLogoutRecord.getActvType())
//                .ip(loginLogoutRecord.getIpAddress())
//                .userAgt(loginLogoutRecord.getUserAgent())
//                .authenticationMthd(loginLogoutRecord.getAuthenticationMthd())
//                .wkstnId(wkstnId)
//                .sessId(loginLogoutRecord.getSessionId())
//                .performedDt(LocalDateTime.now())
//                .build());
//    }
//
//    public void expireSession(HttpServletResponse response) {
//        Cookie expireTokenCookie = new Cookie(WebConstants.HEADER_CSRF_TOKEN, "logout");
//        expireTokenCookie.setPath("/");
//        expireTokenCookie.setHttpOnly(true);
//        expireTokenCookie.setSecure(true);
//        expireTokenCookie.setMaxAge(1);
//        response.addCookie(expireTokenCookie);
//    }
}
