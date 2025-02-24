package com.io_programming.advance.json_csv;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";

        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = objectMapper.readValue(new File(jsonFile), objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));

            // Write to CSV
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                // Writing the header
                writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"});
                // Writing the student data
                for (Student student : students) {
                    writer.writeNext(new String[]{String.valueOf(student.getId()), student.getName(), String.valueOf(student.getAge()), String.valueOf(student.getMarks())});
                }
            }

            System.out.println("JSON to CSV conversion successful!");

        } catch (Exception e) {
            System.out.println(e.getMessage());        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
}
