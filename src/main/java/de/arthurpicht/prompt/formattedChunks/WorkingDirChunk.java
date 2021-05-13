package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.WorkingDir;

public class WorkingDirChunk {

    public static String get() {
            return Color.colorize(WorkingDir.getWorkingDir(), Colors.blueText);
    }

}
