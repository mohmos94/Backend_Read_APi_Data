package com.mohmos.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteFile {
    /**
     *method for writing the content to file for the given path
     * @param path to save the txt file
     * @param data data to write into the txt file
     * @return return true if the data was written into the txt file
     */
    public static boolean writeToFile(String path, String data){
        // Create the file writer instance
        FileWriter write_To_File = null;

        // try catch for running file

        try {
            write_To_File = new FileWriter(path, StandardCharsets.UTF_8);
            write_To_File.write(data);
        }

        catch (IOException e) {
            e.getMessage();
        }
        finally {
            try {
                if(write_To_File != null) {
                    write_To_File.close();
                    return true;
                }
            }
            catch (IOException e) {
                if(e.getMessage() != null){
                    e.getMessage();
                }
                else{
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
