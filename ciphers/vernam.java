package ciphers;

import java.util.*;

public class vernam{
    public static String encrypt(String text,String key){
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase().replaceAll("[^A-Z]", "");

        if (text.length() != key.length()) {
            throw new IllegalArgumentException("Key length must match plaintext length!");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            // Convert char to 0-25
            int pt = text.charAt(i) - 'A';
            int k = key.charAt(i) - 'A';

            // XOR
            int c = pt ^ k;

            // Convert back to character
            result.append((char) (c + 'A'));
        }

        return result.toString();
    }
    public static String  decrypt(String plainText,String key){
        return encrypt(plainText, key);
    }

}