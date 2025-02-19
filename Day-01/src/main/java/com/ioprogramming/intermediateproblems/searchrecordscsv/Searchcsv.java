package com.ioprogramming.intermediateproblems.searchrecordscsv;

import java.util.Scanner;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class Searchcsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ashika\\Desktop\\Week-05\\Day-01\\src\\main\\java\\com\\ioprogramming\\intermediateproblems\\searchrecordscsv\\employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] employee;
            // Skip the header line
            reader.readNext();

            while ((employee = reader.readNext()) != null) {
                String name = employee[1];

                if (name.equals("Akshit")) {
                    // Print Department and Salary
                    System.out.println("Name: " + name +", Department: " + employee[2] + ", Salary: " + employee[3]);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
