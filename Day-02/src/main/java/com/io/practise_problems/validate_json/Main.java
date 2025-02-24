package com.io.practise_problems.validate_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ObjectMapper object=new ObjectMapper();

        try {
            FileReader file = new FileReader("sample.json");

            JsonNode jnode=object.readTree(file);
            System.out.println("Json is valid");



        }catch (Exception e){
            System.out.println("Json not valid");
        }
    }
}
