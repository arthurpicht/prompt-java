package de.arthurpicht.prompt;

import de.arthurpicht.prompt.formattedChunks.Branch;
import de.arthurpicht.prompt.formattedChunks.Infrastructure;
import de.arthurpicht.prompt.formattedChunks.UserAtHost;
import de.arthurpicht.prompt.formattedChunks.WorkingDirChunk;

public class Prompt {

    public static String prompt() {

        String prompt;
        try {
            prompt = Infrastructure.get() + UserAtHost.get() + ":" + WorkingDirChunk.get() + Branch.get() + "$ ";
        } catch (Exception e) {
            prompt = "[prompt error]$ ";
        }

        return prompt;
    }

    public static void main(String[] args) {
        System.out.println("" + prompt());
    }

}

