package com.ioprogramming.basicproblems.countrowsincsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ashika\\Desktop\\Week-05\\Day-01\\src\\main\\java\\com\\ioprogramming\\readcsvandprintdata\\student.csv";
        System.out.println("Number of records: " + countRows(filePath));
    }

    public static int countRows(String filePath) {
        int rowCount = 0;
        String line = null; // Explicitly initializing 'line'

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) { // Reading line
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
