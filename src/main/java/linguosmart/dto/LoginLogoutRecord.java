package linguosmart.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginLogoutRecord {

    private String sessionId;
    private String userId;
    private String ipAddress;
    private String userAgent;

}
