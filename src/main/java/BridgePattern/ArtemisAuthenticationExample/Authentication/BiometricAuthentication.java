package BridgePattern.ArtemisAuthenticationExample.Authentication;

import BridgePattern.ArtemisAuthenticationExample.LoginRequestType;

import java.util.Map;

public class BiometricAuthentication implements AuthenticationMethod {

    public boolean login(String loginName, Map<LoginRequestType, String> loginRequest) {
        String signature = loginRequest.get(LoginRequestType.SIGNATURE);
        System.out.println("Logging in " + loginName);
        if (signature == null || signature.isBlank()) {
            System.out.println(">> Failure!");
            System.out.println();
            return false;
        }
        System.out.println("Checking if the handwritten signature is a valid of the stored user...");
        System.out.println(">> Success!");
        System.out.println();
        return true;
    }
}
