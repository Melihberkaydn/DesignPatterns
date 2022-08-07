package BridgePattern.ArtemisAuthenticationExample;

import java.util.Map;

public abstract class Group {

    public AuthenticationMethod authentication;

    public Group() {

    }

    public boolean checkLogin(String loginName, Map<LoginRequestType, String> request) {
        return authentication.login(loginName, request);
    }

    public AuthenticationMethod getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationMethod authentication) {
        this.authentication = authentication;
    }

}
