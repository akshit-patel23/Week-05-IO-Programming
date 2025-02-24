package com.io_programming.intermediate.search_record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file="employees.csv";

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter full name of the employee: ");
        String name=sc.nextLine();

        String line;
        try{

            BufferedReader bf=new BufferedReader(new FileReader(file));
            boolean f=false;
            while ((line= bf.readLine())!=null){
                String col[]=line.split(",");
                if(col[1].equalsIgnoreCase(name)){
                    System.out.println("ID: "+col[0]+", Name: "+col[1]+", Department: "+col[2]+", Salary: "+col[3]);
                    f=true;
                }
                if(f)break;
            }
            if(!f) System.out.println("Record not Found!!");



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
