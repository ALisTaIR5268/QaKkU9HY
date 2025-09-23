// 代码生成时间: 2025-09-23 19:25:53
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

@ManagedBean
@RequestScoped
public class HashValueCalculator {
    private static final Logger LOGGER = Logger.getLogger(HashValueCalculator.class.getName());

    private String inputString;
    private String selectedAlgorithm = "SHA-256";
    private String hashValue;

    // Getter and setter for inputString
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    // Getter and setter for selectedAlgorithm
    public String getSelectedAlgorithm() {
        return selectedAlgorithm;
    }

    public void setSelectedAlgorithm(String selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }

    // Getter for hashValue
    public String getHashValue() {
        return hashValue;
    }

    /**
     * Calculate the hash value of the input string using the selected algorithm.
     * @return The calculated hash value.
     */
    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance(selectedAlgorithm);
            byte[] hashBytes = digest.digest(inputString.getBytes());
            hashValue = bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.severe("Failed to calculate hash value: " + e.getMessage());
            hashValue = "Error calculating hash value";
        }
        return hashValue;
    }

    /**
     * Convert byte array to hexadecimal string.
     * @param bytes The byte array to convert.
     * @return Hexadecimal string representation of the byte array.
     */
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
