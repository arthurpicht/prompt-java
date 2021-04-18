package de.arthurpicht.dynamicPrompt.helper;

import de.arthurpicht.dynamicPrompt.Config;

public class ExceptionHandler {

    public static void handle(Exception e) {
        if (Config.isDebug()) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void processExitedWithError(String message, int errorCode) {
        if (Config.isDebug()) {
            System.out.println("Process exited with error: " + message);
            System.out.println("Error Code: " + errorCode);
        }
    }

    public static void message(String message) {
        if (Config.isDebug()) {
            System.out.println(message);
        }
    }

}
