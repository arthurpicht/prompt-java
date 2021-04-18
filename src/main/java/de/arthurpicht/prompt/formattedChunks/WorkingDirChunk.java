package de.arthurpicht.prompt.formattedChunks;

import com.diogonunes.jcolor.Ansi;
import de.arthurpicht.prompt.Config;
import de.arthurpicht.prompt.info.WorkingDir;

public class WorkingDirChunk {

    public static String get() {
        if (Config.isColorize()) {
            return Ansi.colorize(WorkingDir.getWorkingDir(), Colors.blueText);
        } else {
            return WorkingDir.getWorkingDir();
        }
    }

}
