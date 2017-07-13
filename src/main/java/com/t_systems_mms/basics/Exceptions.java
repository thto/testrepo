package com.t_systems_mms.basics;


import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by admin on 10.07.2017.
 */
public class Exceptions {
    //private static Logger logger = Logger.getLogger(Exceptions.class);
    private static Logger logger = Logger.getRootLogger();

    public Exceptions(){

    }

    public static void main(String[] args) {
        Exceptions exceptionTest = new Exceptions();
        exceptionTest.readFile("test1.txt");
    }

    private void readFile(String filename) {
        String root = "C:/Thomas/javatest/src/resources/";
        File file = new File(root + filename);
        FileReader fr = null;

        if (file.exists()) {
            logger.debug("fileppath: " + file.getAbsolutePath());
            try {
                fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e3) {
                logger.error("Datei konnte nicht gelesen werden." + e3.getMessage());
            }
        }
        else {
            logger.warn("Datei wurde nicht gefunden: " + filename);
            file = new File(root + getFilename());
            logger.debug("fileppath: " + file.getAbsolutePath());
            try {
                fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    logger.warn(line);
                }
            } catch (IOException e3) {
                logger.error("Datei konnte nicht gelesen werden." + e3.getMessage());
            }
        }
    }

    private String getFilename() {

        logger.warn("Bitte geben Sie den Dateinamen an: ");
        String eingabe = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            eingabe = input.readLine();
        } catch (IOException e2) {
            logger.error("Eingabe konnte nicht gelesen werden." + e2.getMessage());
        }
        return eingabe;
    }

}
