package BridgePattern.ArtemisAuthenticationExample.Authentication;

import BridgePattern.ArtemisAuthenticationExample.Authentication.AuthenticationMethod;
import BridgePattern.ArtemisAuthenticationExample.Authentication.OAuthAuthentication;
import BridgePattern.ArtemisAuthenticationExample.Authentication.TokenBasedAuthentication;
import BridgePattern.ArtemisAuthenticationExample.LoginRequestType;

import java.util.Map;

public class TwoFactorAuthentication implements AuthenticationMethod {
    private OAuthAuthentication oAuth = new OAuthAuthentication();
    private TokenBasedAuthentication token  = new TokenBasedAuthentication();

    public boolean login(String loginName, Map<LoginRequestType, String> loginRequest) {
        if(oAuth.login(loginName, loginRequest)) {
            return token.login(loginName, loginRequest);
        }
        return false;
    }
}
