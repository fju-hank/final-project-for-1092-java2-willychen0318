package com.fju;

import java.util.Calendar;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to movie theater searching system.");
        //choose movie
        System.out.println("Please enter how many adults: ");
        int adults=Integer.parseInt(sc.next());
        System.out.println("Please enter how many students: ");
        int students=Integer.parseInt(sc.next());
        System.out.println("Please enter how many kids or elder: ");
        int concession= Integer.parseInt(sc.next());
        TicketAdult ta=new TicketAdult();
        TicketStudent ts=new TicketStudent();
        TicketConcession tc=new TicketConcession();
        if(adults>0){
            System.out.println(ta.name+" "+ta.price*adults);
        }
        if (students>0){
            System.out.println(ts.name+" "+ts.price*students);
        }
        if (concession>0){
            System.out.println(tc.name+" "+tc.price*concession);
        }
        System.out.println("You have to pay: "+((ta.price*adults)+(ts.price*students)+(tc.price*concession)));
        if (adults+students+concession<=0){
            System.out.println("Please insert correct number !");
        }
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.getTime());


    }
}
