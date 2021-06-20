package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.BranchStatus;
import de.arthurpicht.prompt.info.Git;

import java.nio.file.Path;

public class GitBranch {

    public static String get() {
        try {
            if (Git.hasGit()) {
                BranchStatus branchStatus = Git.getBranchStatus();
                return getString(branchStatus);
            } else {
                return "";
            }
        } catch (Error | Exception e) {
            return "";
        }
    }

    /**
     * For test purposes.
     */
    public static String get(Path workingDir) {
        BranchStatus branchStatus = Git.getBranchStatus(workingDir);
        return getString(branchStatus);
    }

    private static String getString(BranchStatus branchStatus) {
        if (branchStatus.isNoGit()) return "";

        String branchString = "(" + branchStatus.getBranchName() + ")";

        if (branchStatus.isUnchanged()) return Color.colorize(branchString, Colors.greenText);
        if (branchStatus.isChanged()) return Color.colorize(branchString, Colors.redText);
        return Color.colorize(branchString, Colors.yellowText);
    }

}
