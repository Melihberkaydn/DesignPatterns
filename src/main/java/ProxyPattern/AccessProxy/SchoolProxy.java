package ProxyPattern.AccessProxy;

import java.net.URL;
import java.util.Set;

public class SchoolProxy implements ConnectionInterface {

    // TODO: Implement the SchoolProxy
    private boolean authorized;
    private NetworkConnection networkConnection;
    private Set<String> denylistedHosts;
    private Set<Integer> teacherIDs;
    private URL redirectPage;


    public SchoolProxy(Set<String> denylistedHosts,  URL redirectPage, Set<Integer> teacherIDs) {
        this.denylistedHosts = denylistedHosts;
        this.teacherIDs = teacherIDs;
        this.redirectPage = redirectPage;
        this.networkConnection = new NetworkConnection();
        authorized = false;
    }

    public void login(int teacherID) {
        if (teacherIDs.contains(teacherID)) {
            authorized = true;
            System.out.println("Authorized.");
        } else {
            System.err.println("Wrong ID! Try Again.");
        }
    }

    public void logout() {
        if (!authorized) {
            System.out.println("Not Logged in!");
        } else {
            authorized = false;
        }
    }

    @Override
    public void connect(URL url) {
        if (!authorized && denylistedHosts.contains(url.getAuthority())) {
            System.err.println("Connection to '" + url + "' was rejected!");
            networkConnection.connect(redirectPage);
        }
        networkConnection.connect(url);
    }

    @Override
    public void disconnect() {
        networkConnection.disconnect();
    }

    @Override
    public boolean isConnected() {
        return networkConnection.isConnected();
    }
}
