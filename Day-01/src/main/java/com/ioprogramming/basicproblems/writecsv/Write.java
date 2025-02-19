package com.ioprogramming.basicproblems.writecsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) {
        String filepath="C:\\Users\\Ashika\\Desktop\\Week-05\\untitled\\src\\main\\java\\com\\ioprogramming\\writecsv\\output.csv";

        try(BufferedWriter writer= new BufferedWriter(new FileWriter(filepath))){
            writer.write("ID,Name,Department,Salary\n");

            writer.write("101,Akshit Patel,Finance,94999\n");
            writer.write("102,Rishi Thakur,Teaching,15000\n");
            writer.write("103,Deepak Kumar Singh,Finance,9359\n");
            writer.write("104,Ujjwal Gupta,Hr,99999\n");
            writer.write("105,Viraj Kushwaha,Sales,92000\n");
            System.out.println("CSV file written successfully!");

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
