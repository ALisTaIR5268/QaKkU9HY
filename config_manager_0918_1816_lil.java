// 代码生成时间: 2025-09-18 18:16:13
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Configuration Manager class to handle application configurations.
 */
public class ConfigManager {

    private Properties properties;
    private Map<String, String> configMap;

    /**
     * Constructor that loads configuration from a file.
     * @param configFilePath Path to the configuration file.
     * @throws IOException If there is an error reading the configuration file.
     */
    public ConfigManager(String configFilePath) throws IOException {
        properties = new Properties();
        configMap = new HashMap<>();
        loadConfig(configFilePath);
    }

    /**
     * Loads configuration from the specified file.
     * @param configFilePath The path to the configuration file.
     * @throws IOException If there is an issue reading the configuration file.
     */
    private void loadConfig(String configFilePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(configFilePath)) {
            properties.load(fileInputStream);
            for (String key : properties.stringPropertyNames()) {
                configMap.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            throw new IOException("Error loading configuration: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves a configuration value by key.
     * @param key The key of the configuration value to retrieve.
     * @return The configuration value associated with the key, or null if not found.
     */
    public String getConfigValue(String key) {
        return configMap.get(key);
    }

    /**
     * Sets a configuration value.
     * @param key The key of the configuration value to set.
     * @param value The new value for the configuration key.
     */
    public void setConfigValue(String key, String value) {
        configMap.put(key, value);
        properties.setProperty(key, value);
    }

    /**
     * Saves the current configuration to the file.
     * @param configFilePath The path to the configuration file.
     * @throws IOException If there is an issue writing to the configuration file.
     */
    public void saveConfig(String configFilePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(configFilePath);
             java.io.FileOutputStream fileOutputStream = new FileOutputStream(configFilePath)) {
            properties.store(fileOutputStream, "Updated configuration");
        } catch (IOException e) {
            throw new IOException("Error saving configuration: " + e.getMessage(), e);
        }
    }
}
