package ProxyPattern.AccessProxy;

import java.net.URL;

public interface ConnectionInterface {

	void connect(URL url);

	void disconnect();

	boolean isConnected();

}
