package de.arthurpicht.prompt.info;

import de.arthurpicht.prompt.helper.ExceptionHandler;
import de.arthurpicht.prompt.helper.InputStreamHelper;
import de.arthurpicht.prompt.helper.StringHelper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Git {

    public static boolean hasGit() {
        try {
            Process process = new ProcessBuilder("which", "git").start();
            List<String> result = InputStreamHelper.asStringList(process.getInputStream());
            if (process.waitFor() > 0) return false;
            return (result.size() > 0);
        } catch (IOException | InterruptedException e) {
            ExceptionHandler.handle(e);
            return false;
        }
    }

    public static String getBranchName(Path workingDir) {
        try {
            Process process = new ProcessBuilder()
                    .command("git", "branch")
                    .directory(workingDir.toAbsolutePath().toFile())
                    .start();
            List<String> result = InputStreamHelper.asStringList(process.getInputStream());
            if (process.waitFor() > 0) return "";
            if (result.size() == 0) return "";

            return StringHelper.getStarMarkedLine(result);

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            ExceptionHandler.handle(e);
            return "";
        }
    }

    public static BranchStatus getBranchStatus() {
        Path workingDir = Paths.get(".").toAbsolutePath();
        return getBranchStatus(workingDir);
    }

    public static BranchStatus getBranchStatus(Path workingDir) {
        String branchName = getBranchName(workingDir);
        if (branchName.isEmpty()) return BranchStatus.getInstanceNoGit();
        if (hasUncommitedChanges(workingDir)) return BranchStatus.getInstanceChanged(branchName);
        if (hasUnpushedCommits(workingDir)) return BranchStatus.getInstanceChanged(branchName);
        if (hasStash(workingDir)) return BranchStatus.getInstanceStashed(branchName);
        return BranchStatus.getInstanceUnchanged(branchName);
    }

    public static boolean hasUncommitedChanges(Path workingDir) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder()
                    .command("git", "status", "--porcelain")
                    .directory(workingDir.toAbsolutePath().toFile());
            Process process = processBuilder.start();

            List<String> result = InputStreamHelper.asStringList(process.getInputStream());
            int exitCode = process.waitFor();
            if (exitCode > 0) {
                ExceptionHandler.processExitedWithError("git status --porcelain", exitCode);
                return false;
            }
            return (result.size() > 0);

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            ExceptionHandler.handle(e);
            return false;
        }
    }

    public static boolean hasUnpushedCommits(Path workingDir) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder()
                    .command("git", "log", "@{u}..")
                    .directory(workingDir.toAbsolutePath().toFile());
            Process process = processBuilder.start();

            List<String> result = InputStreamHelper.asStringList(process.getInputStream());
            int exitCode = process.waitFor();
            if (exitCode > 0) {
                // ignore intentionally
                // will throw error 128 when executed on newly created branch before committed as upstream branch.
                return false;
            }
            return (result.size() > 0);

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            ExceptionHandler.handle(e);
            return false;
        }
    }

    public static boolean hasStash(Path workingDir) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder()
                    .command("git", "stash", "list")
                    .directory(workingDir.toAbsolutePath().toFile());
            Process process = processBuilder.start();

            List<String> result = InputStreamHelper.asStringList(process.getInputStream());
            int exitCode = process.waitFor();
            if (exitCode > 0) {
                ExceptionHandler.processExitedWithError("git stash list", exitCode);
                return false;
            }
            return (result.size() > 0);

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            ExceptionHandler.handle(e);
            return false;
        }
    }


}
