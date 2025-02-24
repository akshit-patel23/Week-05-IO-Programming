package com.io_programming.advance.encrypt_csv;

public class CaesarCipher {

    // Method to encrypt text using Caesar Cipher
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char i : text.toCharArray()) {
            // Check if the character is a letter or a number to shift
            if (Character.isLetterOrDigit(i)) {
                char shifted = (char) (i + shift);
                encrypted.append(shifted);
            } else {
                // For non-alphabetic characters, don't shift
                encrypted.append(i);
            }
        }
        return encrypted.toString();
    }

    // Method to decrypt text using Caesar Cipher
    public static String decrypt(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();

        for (char i : text.toCharArray()) {
            // Check if the character is a letter or a number to shift back
            if (Character.isLetterOrDigit(i)) {
                char shifted = (char) (i - shift);
                decrypted.append(shifted);
            } else {
                // For non-alphabetic characters, don't shift
                decrypted.append(i);
            }
        }
        return decrypted.toString();
    }
}
