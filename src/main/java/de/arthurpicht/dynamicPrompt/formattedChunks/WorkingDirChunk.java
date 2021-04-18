package de.arthurpicht.dynamicPrompt.formattedChunks;

import com.diogonunes.jcolor.Ansi;
import de.arthurpicht.dynamicPrompt.Config;
import de.arthurpicht.dynamicPrompt.info.WorkingDir;

public class WorkingDirChunk {

    public static String get() {
        if (Config.isColorize()) {
            return Ansi.colorize(WorkingDir.getWorkingDir(), Colors.blueText);
        } else {
            return WorkingDir.getWorkingDir();
        }
    }

}
