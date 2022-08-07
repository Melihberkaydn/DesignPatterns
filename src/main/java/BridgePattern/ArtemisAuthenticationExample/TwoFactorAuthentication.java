package BridgePattern.ArtemisAuthenticationExample;

import java.util.Map;

public class TwoFactorAuthentication implements AuthenticationMethod {
    private OAuthAuthentication oAuth = new OAuthAuthentication();
    private TokenBasedAuthentication token  = new TokenBasedAuthentication();



    public boolean login(String loginName, Map<LoginRequestType, String> loginRequest) {
        if(oAuth.login(loginName, loginRequest)) {
            if(token.login(loginName, loginRequest)) {
                return true;
            }
        }
        return false;
    }
}
