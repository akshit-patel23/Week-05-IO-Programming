package com.io_programming.advance.encrypt_csv;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputFile = "students.csv";
        String encryptedFile = "students_encrypted.csv";
        String decryptedFile = "students_decrypted.csv";

        try {
            // Encrypt CSV and Write to a new file
            encryptCSV(inputFile, encryptedFile);

            // Decrypt CSV and Write to a new file
            decryptCSV(encryptedFile, decryptedFile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to encrypt the sensitive fields (Email, Salary) in the CSV file
    public static void encryptCSV(String inputFile, String encryptedFile) throws Exception {
        // Initialize CSV reader and writer
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(encryptedFile))) {

            List<String[]> allRows = reader.readAll();

            // Encrypt sensitive fields in each row (Email, Salary)
            for (String[] row : allRows) {
                String email = row[1]; // Email column
                String salary = row[3]; // Salary column

                // Encrypt Email and Salary using Caesar Cipher with shift of 25
                row[1] = CaesarCipher.encrypt(email, 25);
                row[3] = CaesarCipher.encrypt(salary, 25);

                // Write the encrypted row to the new file
                writer.writeNext(row);
            }

        }
    }

    // Method to decrypt the sensitive fields (Email, Salary) in the CSV file
    public static void decryptCSV(String encryptedFile, String decryptedFile) throws Exception {
        // Initialize CSV reader and writer
        try (CSVReader reader = new CSVReader(new FileReader(encryptedFile));
             CSVWriter writer = new CSVWriter(new FileWriter(decryptedFile))) {

            List<String[]> allRows = reader.readAll();

            // Decrypt sensitive fields in each row (Email, Salary)
            for (String[] row : allRows) {
                String email = row[1]; // Encrypted Email column
                String salary = row[3]; // Encrypted Salary column

                // Decrypt Email and Salary using Caesar Cipher with shift of 25
                row[1] = CaesarCipher.decrypt(email, 25);
                row[3] = CaesarCipher.decrypt(salary, 25);

                // Write the decrypted row to the new file
                writer.writeNext(row);
            }

        }
    }
}
