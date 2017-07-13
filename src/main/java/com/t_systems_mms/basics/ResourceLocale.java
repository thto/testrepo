package com.t_systems_mms.basics;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceLocale extends Echo implements Greeting {
    private static Logger logger = Logger.getLogger(ResourceLocale.class);
    private static ResourceBundle bundle;
    private static String basename = "resources.einfuehrung";
    static {
        Locale.setDefault( new Locale("en", "EN") );
        bundle = ResourceBundle.getBundle(basename);
    }

    public ResourceLocale() {
    }

    /**
     * prints message to console in dependence of Locale
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        ResourceLocale test = new ResourceLocale();
        printMessage(test.getMessage());
    }

    private static void printMessage(String message) {
        logger.warn(message);
    }

    /**
     * returns Message-String
     * @return Message-String
     */
    public String getMessage() {
        String land = bundle.getString("land");
        String hello = bundle.getString("hello");
        return hello + " in " + land;
    }

}