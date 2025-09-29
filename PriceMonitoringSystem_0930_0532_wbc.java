// 代码生成时间: 2025-09-30 05:32:41
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * PriceMonitoringSystem is a managed bean that handles price monitoring functionality.
 * It observes price changes and updates the monitored prices accordingly.
 */
@ManagedBean
@ViewScoped
public class PriceMonitoringSystem extends Observable implements Observer, Serializable {

    private Map<String, Double> monitoredPrices;
    private double threshold; // The threshold for price changes

    /**
     * Initializes the monitored prices map and sets the threshold.
     */
    public PriceMonitoringSystem() {
        monitoredPrices = new HashMap<>();
        threshold = 0.1; // Default threshold
    }

    /**
     * Adds a product to the price monitoring system.
     * @param productID The ID of the product to monitor.
     * @param initialPrice The initial price of the product.
     */
    public void addProduct(String productID, double initialPrice) {
        monitoredPrices.put(productID, initialPrice);
        System.out.println("Product added to monitoring system: " + productID + " with initial price: " + initialPrice);
    }

    /**
     * Updates the price of a product in the monitoring system.
     * @param productID The ID of the product to update.
     * @param newPrice The new price of the product.
     */
    public void updatePrice(String productID, double newPrice) {
        Double oldPrice = monitoredPrices.get(productID);
        if (oldPrice != null && Math.abs(newPrice - oldPrice) > threshold) {
            monitoredPrices.put(productID, newPrice);
            setChanged(); // Mark this object as having been changed
            notifyObservers(productID); // Notify observers about the change
            System.out.println("Price update for product: " + productID + " from " + oldPrice + " to " + newPrice);
        } else {
            System.out.println("Price update not significant enough to notify: " + productID + " from " + oldPrice + " to " + newPrice);
        }
    }

    /**
     * Returns the monitored prices map.
     * @return The map of monitored prices.
     */
    public Map<String, Double> getMonitoredPrices() {
        return monitoredPrices;
    }

    @Override
    public void update(Observable o, Object arg) {
        // This method is called when the observed object changes.
        if (arg instanceof String) {
            String productID = (String) arg;
            Double price = monitoredPrices.get(productID);
            System.out.println("Notified of price change for product: " + productID + " to price: " + price);
        }
    }
}
