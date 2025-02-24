package com.io_programming.advance.read_large_file;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String file = "sample.csv";  // Large CSV file
        int chunkSize = 100;  // Number of lines to process at a time
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
                // Process the line (dummy processing)
                System.out.println("Processing: " + line);

                if (count % chunkSize == 0) {
                    totalProcessed += count;
                    System.out.println("Processed " + totalProcessed + " records...");
                    count = 0; // Reset counter
                }
            }

            // Final count if remaining records exist
            totalProcessed += count;
            System.out.println("Total records processed: " + totalProcessed);
        } catch (IOException e) {
            System.out.println(e.getMessage());        }
    }
}
