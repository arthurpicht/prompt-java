package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.info.SSH;

public class SshConnection {

    public static String getSshSign() {
        try {
            if (SSH.isSshConnection()) {
//            return Color.colorize(Signs.upwardsArrowFromBar(), Colors.yellowText) + " ";
                return Symbols.yellowDegree();
            } else {
                return "";
            }
        } catch (Error | Exception throwable) {
            return "";
        }
    }

}
