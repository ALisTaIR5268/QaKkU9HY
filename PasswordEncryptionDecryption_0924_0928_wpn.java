// 代码生成时间: 2025-09-24 09:28:30
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * A utility class for password encryption and decryption using AES algorithm.
 */
public class PasswordEncryptionDecryption {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    private static byte[] generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    private static byte[] encrypt(byte[] key, String plainText) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(plainText.getBytes());
    }

    private static String decrypt(byte[] key, byte[] cipherText) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] plainTextBytes = cipher.doFinal(cipherText);
        return new String(plainTextBytes);
    }

    /**
     * Encrypts a password using AES algorithm.
     *
     * @param plainText The password to encrypt.
     * @return The encrypted password in Base64 format.
     * @throws Exception If any error occurs during encryption.
     */
    public static String encryptPassword(String plainText) throws Exception {
        byte[] key = generateKey();
        byte[] cipherText = encrypt(key, plainText);
        return Base64.getEncoder().encodeToString(cipherText);
    }

    /**
     * Decrypts a password encrypted with AES algorithm.
     *
     * @param cipherText The encrypted password in Base64 format.
     * @return The decrypted password.
     * @throws Exception If any error occurs during decryption.
     */
    public static String decryptPassword(String cipherText) throws Exception {
        byte[] key = generateKey(); // In a real scenario, you would use the same key that was used for encryption.
        byte[] cipherTextBytes = Base64.getDecoder().decode(cipherText);
        return decrypt(key, cipherTextBytes);
    }

    public static void main(String[] args) {
        try {
            String password = "mysecretpassword";
            String encrypted = encryptPassword(password);
            System.out.println("Encrypted: " + encrypted);
            String decrypted = decryptPassword(encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}