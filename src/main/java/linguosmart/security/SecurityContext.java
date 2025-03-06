package linguosmart.security;


import linguosmart.domain.User;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString(callSuper = true)
@Builder
public class SecurityContext implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;

    private boolean authenticated;

//    private CsrfToken csrfToken;

    private Long selectedPostId;

    private Set<String> availableFunctions;


    private boolean overriddenProfileIndicator;

    private boolean supervisorIndicator;

    private LocalDateTime lastLoginDatetime;
}
