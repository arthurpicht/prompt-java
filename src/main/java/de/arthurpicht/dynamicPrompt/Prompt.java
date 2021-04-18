package de.arthurpicht.dynamicPrompt;

import de.arthurpicht.dynamicPrompt.formattedChunks.Branch;
import de.arthurpicht.dynamicPrompt.formattedChunks.UserAtHost;
import de.arthurpicht.dynamicPrompt.formattedChunks.WorkingDirChunk;

public class Prompt {

    public static String prompt() {
//        return UserName.getUserName() + "@" + HostName.getHostName() + ":" + WorkingDir.getWorkingDir() + "$ ";
        return UserAtHost.get() + ":" + WorkingDirChunk.get() + Branch.get() + "$ ";
    }

    public static void main(String[] args) {
        System.out.println("3_" + prompt());
    }

}

