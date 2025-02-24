package com.io.practise_problems.json_array_java_objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private String name;
    private int age;
    private String email;

    // Constructor
    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters (Required for Jackson)
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}
