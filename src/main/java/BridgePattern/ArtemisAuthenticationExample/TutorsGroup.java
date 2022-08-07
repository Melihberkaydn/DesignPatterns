package BridgePattern.ArtemisAuthenticationExample;

public class TutorsGroup extends Group{
    // TODO
    public TutorsGroup() {
        //TwoFactorAuthentication twoFactor = new TwoFactorAuthentication();
        setAuthentication(new TwoFactorAuthentication());
    }
}
