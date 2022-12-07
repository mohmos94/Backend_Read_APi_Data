package com.mohmos.FixerIo;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static com.mohmos.File.WriteFile.writeToFile;
import static com.mohmos.JDBC.JDBCInsert.insertDB;

public class Parse_Currency_Data {

    /**
     * Get the data from the json file and convert to data file for processing into database
     */
    public static void parse_Data_Currency(){

        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader("Data.txt"));
            JSONObject jsonObject = (JSONObject) object;
            String base = (String) jsonObject.get("base");
            String date = (String) jsonObject.get("date");
            JSONObject rate = (JSONObject) jsonObject.get("rates");
            Double GBP = (Double) rate.get("GBP");
            Double EUR = (Double) rate.get("EUR");
            Double USD = (Double) rate.get("USD");

            String currency = "" +
                    "Hei, \n" +
                    "Dette er oppdatert valuaverdier mot Norske kroner." +
                    "\n" +
                    "\n" +
                    "Date:" + date +
                    '\n' + "base: " + base +
                    '\n' + "GBP: " + GBP +
                    '\n' + "EUR: " + EUR +
                    '\n' + "USD: " + USD +
                    "\n" +
                    "\n" +
                    "Med vennlig hilsen \n" +
                    "\n" +
                    "Mostafa Mohammedi";


            System.out.println(currency);

            insertDB(date, "GBP", GBP);
            insertDB(date, "EUR", EUR);
            insertDB(date, "USD", USD);

            writeToFile("json.txt" ,currency);

            writeToFile("Data.txt","");



        }

        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
