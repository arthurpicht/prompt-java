package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.WorkingDirString;

public class WorkingDir {

    public static String get() {
            return Color.colorize(WorkingDirString.get(), Colors.blueText);
    }

}
