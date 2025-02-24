package com.io_programming.advance.duplicate_csv;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file = "duplicate.csv"; // CSV File containing ID, Name, Age
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                String id = columns[0].trim(); // Extract ID (first column)

                if (!uniqueIds.add(id)) { // If ID already exists in the set, it's a duplicate
                    duplicates.add(line);
                }
            }

            // Print duplicate records
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String duplicate : duplicates) {
                    System.out.println(duplicate);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());        }
    }
}
