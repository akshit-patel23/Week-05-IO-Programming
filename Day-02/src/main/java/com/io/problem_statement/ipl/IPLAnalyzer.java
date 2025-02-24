package com.io.problem_statement.ipl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class IPLAnalyzer {
    private static final List<String> censoredWords = Arrays.asList("brutal", "furious", "aggressive");

    public static void main(String[] args) {
        // Process JSON file
        List<Map<String, Object>> jsonData = readJSON("ipl_matches.json");
        if (jsonData != null) {
            List<Map<String, Object>> cleanedJsonData = applyCensorship(jsonData);
            writeJSON("ipl_matches_sanitized.json", cleanedJsonData);
        }

        // Process CSV file
        List<String[]> csvData = readCSV("ipl_matches.csv");
        if (csvData != null) {
            List<String[]> cleanedCsvData = applyCensorshipCSV(csvData);
            writeCSV("ipl_matches_sanitized.csv", cleanedCsvData);
        }

        System.out.println("IPL Data processed successfully!");
    }

    private static List<Map<String, Object>> readJSON(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Map<String, Object>>>() {});
        } catch (IOException e) {
            System.out.println("❌ Error reading JSON: " + e.getMessage());
            return null;
        }
    }

    private static void writeJSON(String filePath, List<Map<String, Object>> data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), data);
        } catch (IOException e) {
            System.out.println("❌ Error writing JSON: " + e.getMessage());
        }
    }

    private static List<String[]> readCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            return null;
        }
    }

    // 📌 Write CSV File
    private static void writeCSV(String filePath, List<String[]> data) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(data);
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static List<Map<String, Object>> applyCensorship(List<Map<String, Object>> data) {
        for (Map<String, Object> match : data) {
            String commentary = (String) match.get("commentary");
            if (commentary != null) {
                match.put("commentary", censorText(commentary));
            }
        }
        return data;
    }

    private static List<String[]> applyCensorshipCSV(List<String[]> data) {
        for (int i = 1; i < data.size(); i++) { // Skipping the header
            data.get(i)[5] = censorText(data.get(i)[5]); // Commentary is in 6th column (index 5)
        }
        return data;
    }

    private static String censorText(String text) {
        for (String word : censoredWords) {
            text = text.replaceAll("(?i)" + word, "****");
        }
        return text;
    }
}

