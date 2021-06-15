package com.fju;

import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Scanner;

public class Tester {
    private static HttpURLConnection connection;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to FJU movie rental store.");
        System.out.println("Enter a key word to find your movie.");
        //choose movie
        //movie DVD
        String dd="Y";
        while(dd!=null)
        {
        try {
            String keyword=sc.next();
            String search="https://www.omdbapi.com/?apikey=4c75f77b"+"&s="+keyword;
            URL url= new URL(search);
            try {
                connection= (HttpURLConnection) url.openConnection();
                BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
                String line= reader.readLine();
                StringBuffer responseContent= new StringBuffer();
                while (line!=null){
                    responseContent.append(line);
                    line= reader.readLine();
                }
                System.out.println(responseContent.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("Did you find your movie ?");
        System.out.println("Enter 'Y' to rent movie or enter 'N' to searching again");
        dd=sc.next();
        if(dd.equals("Y")){
            dd=null;
            }
        }

        System.out.println("Please enter how many adults: ");
        int adults= Integer.parseInt(sc.next());
        System.out.println("Please enter how many students: ");
        int students= Integer.parseInt(sc.next());
        System.out.println("Please enter how many kids or elder: ");
        int concession= Integer.parseInt(sc.next());
        TicketAdult ta= new TicketAdult();
        TicketStudent ts= new TicketStudent();
        TicketConcession tc= new TicketConcession();
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
        Calendar cal= Calendar.getInstance();
        System.out.println(cal.getTime());

    }
    public static String parse(String responseBody){
        return null;
    }

}
