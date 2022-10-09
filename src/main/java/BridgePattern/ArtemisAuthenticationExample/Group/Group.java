package BridgePattern.ArtemisAuthenticationExample.Group;

import BridgePattern.ArtemisAuthenticationExample.Authentication.AuthenticationMethod;
import BridgePattern.ArtemisAuthenticationExample.LoginRequestType;

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
