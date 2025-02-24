package com.io_programming.advance.merge_csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String file1 = "students1.csv";  // ID, Name, Age
        String file2 = "students2.csv";  // ID, Marks, Grade
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentData = new HashMap<>();

        // Read first file (students1.csv)
        try (CSVReader reader = new CSVReader(new FileReader(file1))) {
            String[] nextLine;
            reader.readNext(); // Skip header
            while ((nextLine = reader.readNext()) != null) {
                studentData.put(nextLine[0], new String[]{nextLine[1], nextLine[2]});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Read second file (students2.csv) and merge data
        try (CSVReader reader = new CSVReader(new FileReader(file2))) {
            String[] nextLine;
            reader.readNext(); // Skip header
            while ((nextLine = reader.readNext()) != null) {
                if (studentData.containsKey(nextLine[0])) {
                    String[] existingData = studentData.get(nextLine[0]);
                    studentData.put(nextLine[0], new String[]{existingData[0], existingData[1], nextLine[1], nextLine[2]});
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Write merged data to a new file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            // Write header
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            // Write student data
            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                writer.writeNext(new String[]{entry.getKey(), entry.getValue()[0], entry.getValue()[1], entry.getValue()[2], entry.getValue()[3]});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Merged CSV created successfully: " + outputFile);
    }
}
