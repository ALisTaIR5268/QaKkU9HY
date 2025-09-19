// 代码生成时间: 2025-09-20 00:10:56
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NetworkStatusChecker {

    // The host to ping for checking network connectivity
    private String host = "8.8.8.8"; // Google's public DNS server

    /**
     * Checks the network connection status by pinging a host.
     * 
     * @return A message indicating whether the network is reachable.
     */
    public String checkNetworkStatus() {
        try {
            // Try to create an InetAddress object for the host
            InetAddress address = InetAddress.getByName(host);
            // If the InetAddress can be created, the network is reachable
            return "The network is reachable.";
        } catch (UnknownHostException e) {
            // If an UnknownHostException is caught, the network is not reachable
            return "The network is not reachable.";
        }
    }

    // Getter and setter for the host property
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
