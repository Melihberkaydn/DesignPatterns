package BridgePattern.ArtemisAuthenticationExample.Group;

import BridgePattern.ArtemisAuthenticationExample.Authentication.BiometricAuthentication;

public class AdministratorGroup extends Group {
    // TODO
    public AdministratorGroup() {
     BiometricAuthentication bio = new BiometricAuthentication();
     setAuthentication(bio);
    }
}
