package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.SSH;

public class SshConnection {

    public static String getSshSign() {
        if (SSH.isSshConnection()) {
            return " " + Color.colorize(Signs.upwardsArrowFromBar(), Colors.yellowText);
        } else {
            return "";
        }
    }

}
