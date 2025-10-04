// 代码生成时间: 2025-10-05 02:35:26
import java.net.HttpURLConnection;
import java.net.URL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

/**
 * Managed Bean to check network connection status
 */
@ManagedBean
@RequestScoped
public class NetworkStatusChecker {

    // Method to check network connection
    public String checkConnection(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Set the connection timeout (in milliseconds)
            con.setConnectTimeout(5000);

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Connection is alive
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Connection is alive", "Connection to " + url + " is successful"));
                return "success";
            } else {
                // Connection failed
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Connection failed", "Failed to connect to " + url));
                return "fail";
            }
        } catch (Exception e) {
            // Handle exceptions
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exception occurred", e.getMessage()));
            return "fail";
        }
    }
}
