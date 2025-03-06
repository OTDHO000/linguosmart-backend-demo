package linguosmart.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityContextHolder {
    public static final String SESSION_SECURITY_CONTEXT = "SESSION_SECURITY_CONTEXT";

    public static Optional<HttpServletRequest> getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return Optional.of(((ServletRequestAttributes) requestAttributes).getRequest());
        }

        return Optional.empty();
    }

    public static Optional<SecurityContext> getSecurityContext() {
        return getRequest().map(request -> {
            HttpSession session = request.getSession();

            return Optional.ofNullable(session.getAttribute(SESSION_SECURITY_CONTEXT)).map(SecurityContext.class::cast).orElse(null);
        });
    }

    public static boolean isUserSessionValid() {
        return getRequest().map(request -> {
            if (request.isRequestedSessionIdValid() && request.isRequestedSessionIdFromCookie()) {
                Object ctx = request.getSession().getAttribute(SESSION_SECURITY_CONTEXT);
                if (ctx != null) {
                    return ((SecurityContext) ctx).isAuthenticated();
                }
            }
            return false;
        }).orElse(false);
    }

    public static void invalidateUserSession() {
        if (isUserSessionValid()) {
            invalidatePreviousSession();
        }
    }

    public static void invalidatePreviousSession() {
        getRequest().ifPresent(request -> {
            HttpSession session = request.getSession();

            session.removeAttribute(SESSION_SECURITY_CONTEXT);
            session.invalidate();
        });
    }
}
