package com.io.practise_problems.java_object_json;

import org.json.JSONObject;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        //linekdhashmap to get object in particular order

        Car car=new Car("Pagani","Koisenge",2016);

        JSONObject json=new JSONObject();
        json.put("name",car.getName());
        json.put("model",car.getModel());
        json.put("price",car.getPrice());

        System.out.println(json.toString(3));


    }

}
