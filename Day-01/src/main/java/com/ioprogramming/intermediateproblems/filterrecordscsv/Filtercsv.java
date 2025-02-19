package com.ioprogramming.intermediateproblems.filterrecordscsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filtercsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ashika\\Desktop\\Week-05\\Day-01\\src\\main\\java\\com\\ioprogramming\\readcsvandprintdata\\student.csv"; // Change this to your CSV file path
        filterHighScorers(filePath);
    }

    public static void filterHighScorers(String filePath) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                String name = data[1].trim();
                int marks = Integer.parseInt(data[3].trim());

                if (marks > 80) {
                    System.out.println(name + " - " + marks);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
