package de.arthurpicht.dynamicPrompt.formattedChunks;

import com.diogonunes.jcolor.Ansi;
import de.arthurpicht.dynamicPrompt.Config;
import de.arthurpicht.dynamicPrompt.info.HostName;
import de.arthurpicht.dynamicPrompt.info.UserName;

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
