package de.arthurpicht.prompt.info;

public class UserName {

    public static String getUserName() {
        String username = System.getProperty("user.name");
        if (username == null || username.isEmpty()) username = "?";
        return username;
    }

}
