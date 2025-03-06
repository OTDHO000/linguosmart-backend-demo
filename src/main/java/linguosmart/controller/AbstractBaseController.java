package linguosmart.controller;

import java.util.Enumeration;
import java.util.Optional;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import linguosmart.domain.User;
import linguosmart.security.SecurityContextHolder;
import linguosmart.security.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public abstract class AbstractBaseController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected Environment environment;

    private static final String SHOW_PARAM_FORMAT = "%02d. %-32s = %s";

    protected Optional<User> getCurrentUser() {
        return SecurityContextHolder.getSecurityContext().map(SecurityContext::getUser);
    }

    protected void printHeadersInfo() {
        int i = 1;
        Enumeration<?> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            log.debug(String.format(SHOW_PARAM_FORMAT, i++, "[" + headerName + "]", request.getHeader(headerName)));
        }
    }

    protected void printRequestParameters() {
        int i = 1;
        Enumeration<?> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = (String) params.nextElement();
            log.debug(String.format(SHOW_PARAM_FORMAT, i++, "[" + paramName + "]", request.getParameter(paramName)));
        }
    }

    protected void printUserSessionInfo() {
        if (null != request.getSession(false)) {
            int i = 1;
            Enumeration<?> keys = request.getSession().getAttributeNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                log.debug(String.format(SHOW_PARAM_FORMAT, i++, "[" + key + "]",
                        request.getSession().getAttribute(key)));
            }
        }
    }

}
