// 代码生成时间: 2025-09-18 00:04:45
package com.example.hashcalculator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ManagedBean for Hash Calculator Tool.
 * This bean handles user input and computes the hash value.
 */
@ManagedBean
@ViewScoped
public class HashCalculatorBean {

    private static final Logger LOGGER = Logger.getLogger(HashCalculatorBean.class.getName());

    private String input;
    private String hashType;
    private String result;

    /**
     * Getter for the input string.
     * @return the input string.
     */
    public String getInput() {
        return input;
    }

    /**
     * Setter for the input string.
     * @param input the input string to set.
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Getter for the hash type.
     * @return the hash type.
     */
    public String getHashType() {
        return hashType;
    }

    /**
     * Setter for the hash type.
     * @param hashType the hash type to set.
     */
    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    /**
     * Getter for the result hash value.
     * @return the result hash value.
     */
    public String getResult() {
        return result;
    }

    /**
     * Computes the hash value for the given input and hash type.
     * @return the computed hash value.
     */
    public String computeHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance(hashType);
            byte[] hash = digest.digest(input.getBytes());
            result = bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.SEVERE, "Hash algorithm not found", e);
            result = "Hash algorithm not found";
        }
        return result;
    }

    /**
     * Converts a byte array to a hex string.
     * @param bytes the byte array to convert.
     * @return the hex string representation of the byte array.
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
