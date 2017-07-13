package com.t_systems_mms.basics;

import org.apache.log4j.Logger;

public class HelloRecipient extends Echo implements Greeting {
    private static Logger logger = Logger.getLogger(HelloRecipient.class);

    public HelloRecipient() {
    }

    /**
     * prints "hello"-message to console
     * @param args
     */
    public static void main(String[] args) {
        HelloRecipient hello = new HelloRecipient();
        String recipient = hello.getRecipient();
        printMessage(hello.getMessage() + recipient);
    }

    private static void printMessage(String message) {
        logger.warn(message);
    }

    /**
     * returns Greeting-String
     * @return Greeting-String
     */
    public String getMessage() {
        return "Hello ";
    }
}
