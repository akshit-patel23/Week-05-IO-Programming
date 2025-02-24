package com.io_programming.intermediate.sort_csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file = "employees.csv"; // CSV file path
        List<String[]> records;

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            records = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        // Remove the header row
        String[] header = records.remove(0);

        // Sort records by Salary column (index 3) in descending order using a simple loop
        for (int i = 0; i < records.size(); i++) {
            for (int j = i + 1; j < records.size(); j++) {
                int salary1 = Integer.parseInt(records.get(i)[3]);
                int salary2 = Integer.parseInt(records.get(j)[3]);
                if (salary1 < salary2) {
                    String[] temp = records.get(i);
                    records.set(i, records.get(j));
                    records.set(j, temp);
                }
            }
        }

        // Print Header
        System.out.println(String.join(", ", header));

        // Print Top 5 Highest Paid Employees
        for (int i = 0; i < Math.min(5, records.size()); i++) {
            System.out.println(String.join(", ", records.get(i)));
        }
    }
}
