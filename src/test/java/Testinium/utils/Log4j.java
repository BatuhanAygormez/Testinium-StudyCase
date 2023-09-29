package Testinium.utils;

import org.apache.log4j.Logger;

public class Log4j {
    private static final Logger Log = Logger.getLogger(Log4j.class.getName());

    //Info for Step
    public static void step(String message) {
        Log.info("--> " + message);
    }

    //Info Level 
    public static void info(String message) {
        Log.info(message);
    }

    //Warn Level 
    public static void warn(String message) {
        Log.warn(message);
    }

    //Error Level 
    public static void error(String message) {
        Log.error(message);
    }

    //Fatal Level 
    public static void fatal(String message) {
        Log.fatal(message);
    }

    //Debug Level 
    public static void debug(String message) {
        Log.debug(message);
    }
}