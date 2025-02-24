package com.io.hands_on_practise.filter_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        try {
            // Load JSON file
            File file = new File("sample.json"); // Make sure the JSON file exists
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON as an array
            JsonNode rootArray = objectMapper.readTree(file);

            // List to store filtered records
            List<JsonNode> filteredRecords = new ArrayList<>();

            // Iterate and filter records where age > 25
            for (JsonNode node : rootArray) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            // Print filtered JSON records
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredRecords));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}