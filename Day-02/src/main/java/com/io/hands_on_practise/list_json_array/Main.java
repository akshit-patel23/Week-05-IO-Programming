package com.io.hands_on_practise.list_json_array;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.practise_problems.json_array_java_objects.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Creating a list of Student objects
            List<Student> students = Arrays.asList(
                    new Student("Ujjwal Gupta", 21, "ujjwal@gmail.com"),
                    new Student("Akshit Patel", 22, "akshit@gmail.com"),
                    new Student("Deepak Singh", 23, "deepak@gmail.com")
            );

            // Convert list to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArrayString = objectMapper.writeValueAsString(students);

            // Convert to JSONArray (org.json)
            JSONArray jsonArray = new JSONArray(jsonArrayString);

            // Print formatted JSON
            System.out.println(jsonArray.toString(4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
