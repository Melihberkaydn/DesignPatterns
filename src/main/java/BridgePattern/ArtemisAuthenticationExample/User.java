package BridgePattern.ArtemisAuthenticationExample;

import BridgePattern.ArtemisAuthenticationExample.Group.Group;

import java.util.Map;

public class User {

    private final String name;
    private final Group group;
    private String fullName;

    public User(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public boolean login(Map<LoginRequestType, String> loginRequest) {
        return group.checkLogin(name, loginRequest);
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
