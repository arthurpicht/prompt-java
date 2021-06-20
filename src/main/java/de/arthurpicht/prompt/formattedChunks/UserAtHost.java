package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.HostName;
import de.arthurpicht.prompt.info.UserName;

public class UserAtHost {

    public static String get() {
        StringBuilder userAtHost = new StringBuilder();

        if (UserName.getUserName().equals("root")) {
            userAtHost.append(Color.colorize(UserName.getUserName(), Colors.redText));
        } else {
            userAtHost.append(Color.colorize(UserName.getUserName(), Colors.greenText));
        }

//        userAtHost.append(Symbols.whiteAdd());
        userAtHost.append(Symbols.getGreenAt());

        userAtHost.append(Color.colorize(HostName.getHostName(), Colors.greenText));

        return userAtHost.toString();
    }

}
