package BridgePattern.ArtemisAuthenticationExample;

import java.util.Map;

public interface AuthenticationMethod {
    boolean login(String loginName, Map<LoginRequestType, String> loginRequest);
}
