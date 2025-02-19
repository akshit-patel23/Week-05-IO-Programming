package com.ioprogramming.basicproblems.readcsvandprintdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Read {
    public static void main(String[] args) {
        String filepath="C:\\Users\\Ashika\\Desktop\\Week-05\\untitled\\src\\main\\java\\com\\ioprogramming\\readcsvandprintdata\\student.csv";
        try(BufferedReader br= new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line=br.readLine())!=null){
                String[] columns=line.split(",");
                System.out.println("ID: "+columns[0]+",Name: "+columns[1]+",Marks: "+columns[3]+",Age: "+columns[2]);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
