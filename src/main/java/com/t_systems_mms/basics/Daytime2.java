package com.t_systems_mms.basics;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Calendar;

public class Daytime2 extends Echo implements Greeting {
    private static Logger logger = Logger.getLogger(Daytime.class);
    public String logRecipient = "";

    public Daytime2() {
    }

    /**
     * prints message to console in dependence on daytime
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

    }

    public void createMessage() {
        Calendar currentDate = Calendar.getInstance();
        int hour = currentDate.get(Calendar.HOUR_OF_DAY);
        int minute = currentDate.get(Calendar.MINUTE);

        Daytime2 daytime = new Daytime2();
        if (hour <= 10 && hour >= 0) {
            daytime.setRecipient("Morning");
        }
        else if (hour > 10 && hour < 18) {
            daytime.setRecipient("Afternoon");
        }
        else if (hour >= 18 && hour <= 23) {
            daytime.setRecipient("Evening");
        }
        logRecipient = daytime.getRecipient();
        printMessage(daytime.getMessage() + daytime.getRecipient() + " , it's: " + hour + ":" + minute);
    }

    private static void printMessage(String message) {
        logger.warn(message);
    }

    /**
     * implementation of interface Greeting
     * @return String (Greeting)
     */
    public String getMessage() {
        return "Good ";
    }

}

