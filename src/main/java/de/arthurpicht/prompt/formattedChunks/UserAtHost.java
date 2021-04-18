package de.arthurpicht.prompt.formattedChunks;

import com.diogonunes.jcolor.Ansi;
import de.arthurpicht.prompt.Config;
import de.arthurpicht.prompt.info.HostName;
import de.arthurpicht.prompt.info.UserName;

public class UserAtHost {

    public static String get() {
        String userAtHost = UserName.getUserName() + "@" + HostName.getHostName();

        if (Config.isColorize()) {
            return Ansi.colorize(userAtHost, Colors.greenText);
        } else {
            return userAtHost;
        }

    }

}
