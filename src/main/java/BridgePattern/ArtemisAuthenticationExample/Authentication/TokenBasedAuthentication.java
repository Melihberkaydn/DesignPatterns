package BridgePattern.ArtemisAuthenticationExample.Authentication;

import BridgePattern.ArtemisAuthenticationExample.LoginRequestType;

import java.util.Map;

public class TokenBasedAuthentication implements AuthenticationMethod {

    /*
     * DO NOT MODIFY THIS CLASS!
     */

    public boolean login(String loginName, Map<LoginRequestType, String> loginRequest) {
        System.out.println("Checking credentials by external identity provider '" + loginName + "'...");
        if (loginName.hashCode() % 3 == 0) {
            System.out.println(">> Failure!");
            System.out.println();
            return false;
        }
        System.out.println(">> Success!");
        System.out.println();
        return true;
    }
}
