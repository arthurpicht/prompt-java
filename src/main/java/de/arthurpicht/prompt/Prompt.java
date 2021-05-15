package de.arthurpicht.prompt;

import de.arthurpicht.prompt.formattedChunks.*;

public class Prompt {

    public static String prompt(String exitCode) {

        String prompt;
        try {
            prompt = SshConnection.getSshSign() + Infrastructure.get() + UserAtHost.get() + Signs.whiteColon()
                    + WorkingDirChunk.get() + Branch.get()
                    + ExitStatus.get(exitCode)
                    + Signs.termination();

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
        String exitCode = args.length > 0 ? args[0] : "";
        System.out.println(prompt(exitCode));
    }

}

