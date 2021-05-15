package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.ExitStatusOfLastCommand;

/**
 * Does not work. Other shell than called from?!
 */
public class ExitStatus {

    public static String get() {
        String exitStatus = ExitStatusOfLastCommand.get();
        if (exitStatus.equals("0")) return "";

        String exitStatusString = "[" + exitStatus + "]";
        return Color.colorize(exitStatusString, Colors.redText);
    }

    public static String get(String exitCode) {
        if (!exitCode.equals("") && !exitCode.equals("0")) {
            return Signs.whiteColon() + Color.colorize(exitCode, Colors.redText);
        } else {
            return "";
        }
    }

}
