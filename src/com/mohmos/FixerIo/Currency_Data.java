package com.mohmos.FixerIo;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Currency_Data {

    /**
     * static get method for enabling the HTTP request
     * for reading the fixer.io endpoints
     * @param password API key password
     * @return HTTP connection
     */
    public static HttpURLConnection http_Connection (String password) {
        // HTTP connection
        HttpURLConnection con = null;
        // read and write from the HTTP connection
        BufferedReader reader = null;
        BufferedWriter write = null;
        // variable for Http response
        String api_Key = "apikey";
        password = "cQFofRVIlT4O9koGQ78A5X5dKzuNlx8A";


        StringBuilder stringBuilder = null;
        try {
            // create an URL object from the string representation

            URL url = new URL("https://api.apilayer.com/fixer/latest?symbols=GBP,EUR,USD&base=NOK");

            // create a socket connection wih the URL object
            con = (HttpURLConnection) url.openConnection();

            // adding the API key for accessing the data
            con.setRequestProperty(api_Key, password);

            // add the request method
            con.setRequestMethod("GET");

            // open the connection
            con.connect();

            return con;

        } catch (IOException e) {
           e.printStackTrace();
        }

        return null;
    }


    /**
     *Read data from the Http connection and send it back
     * @param path to save the data from the APi in JSON format
     * @param con http connection string
     */
    public static void readCurrency(String path, HttpURLConnection con){

        // read and write from the HTTP connection
        BufferedReader reader = null;
        BufferedWriter write = null;
        // variable for Http response
        final int HttpResponse = 200;


            // check if the permission for reading the file is granted
        try {
            if(con.getResponseCode() != HttpResponse ){
                throw new IOException("connection with the API failed");
            }

            // read the file and send it to the txt file as a json format structure

            else{
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                write = new BufferedWriter(new FileWriter(path, true));
                String output;

                while ((output = reader.readLine()) != null) {
                    write.append(output);
                    write.newLine();
                    //System.out.println(output);
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(write != null){
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
