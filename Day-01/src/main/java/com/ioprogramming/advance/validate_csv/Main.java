package com.io_programming.advance.validate_csv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String file = "email.csv";

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] nextLine;

            // ✅ Corrected Email Regex (Allows more formats)
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            String phoneRegex = "^\\d{10}$"; // ✅ Phone number must be exactly 10 digits

            Pattern emailPattern = Pattern.compile(emailRegex);
            Pattern phonePattern = Pattern.compile(phoneRegex);

            // Skip the header row
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String name = nextLine[0].trim();
                String email = nextLine[1].trim();
                String phone = nextLine[2].trim();

                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phonePattern.matcher(phone).matches();

                if (!emailValid) {
                    System.out.println("❌ Invalid Email: " + email + " (Name: " + name + ")");
                }

                if (!phoneValid) {
                    System.out.println("❌ Invalid Phone: " + phone + " (Name: " + name + ")");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
