package com.io.practise_problems.student_json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Map<String,Object> map=new LinkedHashMap<>();

        // adding subjects
        JSONArray subjects= new JSONArray();
        subjects.put("Artificial Intelligence");
        subjects.put("Machine Learning");
        subjects.put("Computer Science");



        map.put("name","ujjwal");
        map.put("age",21);
        map.put("subjects",subjects);

        JSONObject json=new JSONObject(map);
        System.out.println(json.toString(4));

    }
}
