package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.HostName;
import de.arthurpicht.prompt.info.UserName;

public class UserAtHost {

    public static String get() {
        String userAtHost = UserName.getUserName() + "@" + HostName.getHostName();
        return Color.colorize(userAtHost, Colors.greenText);
    }

}
