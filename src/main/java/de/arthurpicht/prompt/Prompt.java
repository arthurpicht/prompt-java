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

            // escape trailing $ to prevent unexpected behavior (jumping back cursor), see:
            // https://stackoverflow.com/questions/37424743/sometimes-cursor-jumps-to-start-of-line-in-bash-prompt

            // wrapping correctly:
            // https://unix.stackexchange.com/questions/105958/terminal-prompt-not-wrapping-correctly

        } catch (Exception e) {
            prompt = "[prompt error]$ ";
        }

        return prompt;
    }

    public static void main(String[] args) {
        System.out.println(prompt());
    }

}

