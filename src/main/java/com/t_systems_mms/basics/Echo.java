package com.t_systems_mms.basics;

import org.apache.log4j.Logger;

public abstract class Echo {
    private static Logger logger = Logger.getLogger(Echo.class);

    private String recipient = "World";

    /**
     * returns recipient
     * @return String recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * sets recipient to given String
     * @param recipient sets recipient to given String
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
