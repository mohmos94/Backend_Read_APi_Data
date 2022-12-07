package com.mohmos.File;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    /**
     * @param path the path for the file to be created.
     * @return true of the file was created or false
     */
    public static boolean createFile(String path) {

        // message for file handling

        final String fileExist = String.format("file %s already exist in the current location", path);
        final String createFileMessage = String.format("the %s file was created in the current location.", path);

        // file object to create or read a file

        File fileTesting = new File(path);

        // to check if the file is created

        boolean checkFile;

        // try block to create a file check if file already exist
        try {
            checkFile = fileTesting.createNewFile();

            if (checkFile) {
                System.out.println(createFileMessage);
                return true;
            } else {
                System.out.println(fileExist);
                return true;
            }
            // catch block errorhandling code

        } catch (IOException e) {
            e.getMessage();

        }
        return false;
    }

}
