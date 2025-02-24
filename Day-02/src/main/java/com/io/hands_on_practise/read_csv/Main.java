package com.io.hands_on_practise.read_csv;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into a JsonNode object
            JsonNode rootNode = objectMapper.readTree(new File("sample.json"));

            // Extract "data" array
            JsonNode dataArray = rootNode.get("data");

            // Loop through each object in the array
            for (JsonNode node : dataArray) {
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                System.out.println("Name: " + name + ", Email: " + email);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

