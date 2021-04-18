package de.arthurpicht.prompt.helper;

public class SystemProperties {

    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    public static String getHomeDir() {
        return System.getProperty("user.home");
    }

}
