package com.io.hands_on_practise.json_xml;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // JSON String
            String json = """
            {
                "name": "Ujjwal Gupta",
                "email": "ujjwal@gmail.com",
                "admin": true
            }
            """;

            // Step 1: Convert JSON to Java Object (JsonNode)
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.readTree(json);

            // Step 2: Convert Java Object to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            // Print XML
            System.out.println(xml);

        } catch (Exception e) {
            System.out.println(e.getMessage());        }
    }
}
