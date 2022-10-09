package BridgePattern.ArtemisAuthenticationExample.Authentication;

import BridgePattern.ArtemisAuthenticationExample.LoginRequestType;

import java.util.Map;

public interface AuthenticationMethod {
    boolean login(String loginName, Map<LoginRequestType, String> loginRequest);
}
