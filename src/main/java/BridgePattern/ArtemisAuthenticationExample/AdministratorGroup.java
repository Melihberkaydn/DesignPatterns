package BridgePattern.ArtemisAuthenticationExample;

public class AdministratorGroup extends Group {
    // TODO
    public AdministratorGroup() {
     BiometricAuthentication bio = new BiometricAuthentication();
     setAuthentication(bio);
    }
}
