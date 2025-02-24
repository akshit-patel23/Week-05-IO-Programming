    package com.io.hands_on_practise.email;

    import com.fasterxml.jackson.databind.JsonNode;
    import com.fasterxml.jackson.databind.ObjectMapper;

    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;

    import com.fasterxml.jackson.databind.JsonNode;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.everit.json.schema.Schema;
    import org.everit.json.schema.loader.SchemaLoader;
    import org.json.JSONObject;

    public class EmailValidator {
        public static void main(String[] args) {
            try {
                // JSON Schema for Email Validation
                String schemaStr = """
                {
                  "$schema": "https://json-schema.org/draft/2020-12/schema",
                  "type": "object",
                  "properties": {
                    "email": {
                      "type": "string",
                      "format": "email"
                    }
                  },
                  "required": ["email"]
                }
                """;

                // Sample JSON Data
                String jsonStr = """
                {
                  "email": "ujjwalg@gmail.com"
                }
                """;

                // Convert Strings to JSON Objects
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(jsonStr);
                JSONObject jsonSchema = new JSONObject(schemaStr);
                JSONObject jsonData = new JSONObject(jsonNode.toString());

                // Load Schema & Validate JSON
                Schema schema = SchemaLoader.load(jsonSchema);
                schema.validate(jsonData);

                System.out.println("✅ Email is valid!");

            } catch (Exception e) {
                System.out.println("❌ Invalid email: " + e.getMessage());
            }
        }
    }
