package com.io_programming.advance.db_csv;


import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Path to save the generated CSV file
        String csvFile = "employee_report.csv";

        // Employee data to be written to the CSV file (Dummy data)
        String[][] employees = {
                {"1", "John Doe", "Engineering", "75000"},
                {"2", "Jane Smith", "Marketing", "68000"},
                {"3", "Michael Johnson", "Finance", "90000"},
                {"4", "Emily Davis", "HR", "62000"},
                {"5", "David Lee", "Engineering", "80000"}
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Write header row
            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            // Write employee data rows
            for (String[] employee : employees) {
                writer.writeNext(employee);
            }

            System.out.println("CSV report generated successfully!");

        } catch (IOException e) {
            System.out.println(e.getMessage());        }
    }
}
