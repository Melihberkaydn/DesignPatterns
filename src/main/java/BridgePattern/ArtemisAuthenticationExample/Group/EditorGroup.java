package BridgePattern.ArtemisAuthenticationExample.Group;

import BridgePattern.ArtemisAuthenticationExample.Authentication.OAuthAuthentication;

public class EditorGroup extends Group {

    public EditorGroup() {
        OAuthAuthentication oAuth = new OAuthAuthentication();
        setAuthentication(oAuth);
    }

}
