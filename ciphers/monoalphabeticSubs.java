package ciphers;

import java.util.*;

public class monoalphabeticSubs{
    // Encryption
    public static String encrypt(String plaintext, String key) {
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase().replaceAll("[^A-Z]", "");
        if (key.length() != 26) throw new IllegalArgumentException("Key must have 26 letters");

        StringBuilder cipher = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            int idx = ch - 'A'; // 0-25
            cipher.append(key.charAt(idx));
        }
        return cipher.toString();
    }

    // Decryption
    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase().replaceAll("[^A-Z]", "");
        if (key.length() != 26) throw new IllegalArgumentException("Key must have 26 letters");

        // Build reverse map
        char[] reverse = new char[26];
        for (int i = 0; i < 26; i++) {
            reverse[key.charAt(i) - 'A'] = (char) ('A' + i);
        }

        StringBuilder plaintext = new StringBuilder();
        for (char ch : ciphertext.toCharArray()) {
            plaintext.append(reverse[ch - 'A']);
        }
        return plaintext.toString();
    }
}