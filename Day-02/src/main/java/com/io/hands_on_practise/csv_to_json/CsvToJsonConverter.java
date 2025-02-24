package com.io.hands_on_practise.csv_to_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFile = "students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll(); // Read all rows

            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            // Get header (first row)
            String[] headers = records.get(0);

            // Create JSON Array
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            // Convert remaining rows to JSON
            for (int i = 1; i < records.size(); i++) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                String[] row = records.get(i);

                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]); // Map CSV values
                }

                jsonArray.add(jsonObject);
            }

            // Convert JSON Array to String
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            System.out.println(jsonOutput);

        } catch (Exception e) {
            System.out.println(e.getMessage());        }
    }
}
