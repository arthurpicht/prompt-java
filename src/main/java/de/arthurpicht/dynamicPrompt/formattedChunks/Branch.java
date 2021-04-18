package de.arthurpicht.dynamicPrompt.formattedChunks;

import com.diogonunes.jcolor.Ansi;
import de.arthurpicht.dynamicPrompt.Config;
import de.arthurpicht.dynamicPrompt.info.BranchStatus;
import de.arthurpicht.dynamicPrompt.info.Git;

import java.nio.file.Path;

public class Branch {

    public static String get() {
        BranchStatus branchStatus = Git.getBranchStatus();
        return getString(branchStatus);
    }

    public static String get(Path workingDir) {
        BranchStatus branchStatus = Git.getBranchStatus(workingDir);
        return getString(branchStatus);
    }

    private static String getString(BranchStatus branchStatus) {
        if (branchStatus.isNoGit()) return "";

        String branchString = "(" + branchStatus.getBranchName() + ")";

        if (Config.isColorize()) {
            if (branchStatus.isUnchanged()) return Ansi.colorize(branchString, Colors.greenText);
            if (branchStatus.isChanged()) return Ansi.colorize(branchString, Colors.redText);
            return Ansi.colorize(branchString, Colors.yellowText);
        }

        return branchString;
    }

}
