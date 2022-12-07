package com.mohmos;
import java.net.HttpURLConnection;
import static com.mohmos.File.CreateFile.createFile;
import static com.mohmos.FixerIo.Currency_Data.http_Connection;
import static com.mohmos.FixerIo.Currency_Data.readCurrency;
import static com.mohmos.FixerIo.Parse_Currency_Data.parse_Data_Currency;

public class Main {

    public static void main(String[] args) {
        createFile("Data.txt");
        HttpURLConnection con = http_Connection("");
        readCurrency("Data.txt", con);
        parse_Data_Currency();
    }

}
