package BridgePattern.ArtemisAuthenticationExample;

public class EditorGroup extends Group {

    public EditorGroup() {
        OAuthAuthentication oAuth = new OAuthAuthentication();
        setAuthentication(oAuth);
    }

}
