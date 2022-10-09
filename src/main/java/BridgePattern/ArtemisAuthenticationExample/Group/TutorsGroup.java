package BridgePattern.ArtemisAuthenticationExample.Group;

import BridgePattern.ArtemisAuthenticationExample.Authentication.TwoFactorAuthentication;

public class TutorsGroup extends Group{
    // TODO
    public TutorsGroup() {
        //TwoFactorAuthentication twoFactor = new TwoFactorAuthentication();
        setAuthentication(new TwoFactorAuthentication());
    }
}
