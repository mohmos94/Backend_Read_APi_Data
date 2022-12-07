package com.mohmos.File;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    /**
     * Read the txt file from the given path
     * @param path string path for reading file
     * @return return true if the file is read
     */
    public static boolean readFile(String path){

        // create an instance of the readfile
        FileReader readFile = null;
        // Try Catch for reading file
        try {

                readFile = new FileReader(path);

                //output data to console
                int i;
                while ((i = readFile.read()) != -1) {
                    System.out.print((char)i);


            }
        }

        catch (IOException e) {
            e.getMessage();
        }

        finally {
            try {
                if(readFile != null) {
                    readFile.close();
                    return true;
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }

        return false;
    }

}
