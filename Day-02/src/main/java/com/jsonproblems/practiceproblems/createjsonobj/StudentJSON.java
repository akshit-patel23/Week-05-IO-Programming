package com.jsonproblems.practiceproblems.createjsonobj;

import org.json.JSONObject;

public class StudentJSON {
    public static void main(String[] args) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Akshit");
            jsonObject.put("age", 22);
            jsonObject.put("email", "akshitpatel.g@gmail.com");
            System.out.println(jsonObject.toString()); // Convert to JSON String

        }
}
