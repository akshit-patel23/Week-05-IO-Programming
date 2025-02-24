package com.io_programming.advance.csv_data_objects;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;




public class Main {
    public static void main(String[] args) {
        String file = "student.csv";  // CSV File Path
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0].trim());
                String name = nextLine[1].trim();
                int age = Integer.parseInt(nextLine[2].trim());
                double marks = Double.parseDouble(nextLine[3].trim());

                // Create Student object and add to list
                studentList.add(new Student(id, name, age, marks));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Print all students
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
