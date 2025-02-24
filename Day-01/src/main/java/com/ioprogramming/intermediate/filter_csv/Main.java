package com.io_programming.intermediate.filter_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParsePosition;

public class Main {
    public static void main(String[] args) {

        String file="sample.csv";

        try{

            BufferedReader bf=new BufferedReader(new FileReader(file));
            String line;

            while((line= bf.readLine())!=null){


                String col[]=line.split(",");
                if (col.length < 3) {
                    continue; // Skip invalid lines
                }
                if(Integer.parseInt(col[2])>80){
                    System.out.println("ID: "+col[0]+", Name: "+col[1]+", Marks: "+col[2]);

                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
