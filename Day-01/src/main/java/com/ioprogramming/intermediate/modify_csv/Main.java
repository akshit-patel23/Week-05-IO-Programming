package com.io_programming.intermediate.modify_csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = "employees.csv";
        List<String[]> list;

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            list = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        for (String[] it : list) {
            // Check if row has at least 4 columns**
            if (it.length >= 4 && !it[0].equalsIgnoreCase("id")) {
                if (it[2].equalsIgnoreCase("it")) {
                    int temp = Integer.parseInt(it[3]);
                    double hike = temp * 0.1;
                    double sal = temp + hike;
                    it[3] = String.valueOf(sal);
                }
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeAll(list);
        }
    }
}
