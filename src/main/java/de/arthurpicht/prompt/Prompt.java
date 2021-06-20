package de.arthurpicht.prompt;

import de.arthurpicht.prompt.formattedChunks.*;

public class Prompt {

    public static String prompt(String exitCode) {

        String prompt;
        try {
            prompt = SshConnection.getSshSign() + Infrastructure.get() + UserAtHost.get() + ":"
                    + WorkingDir.get() + GitBranch.get()
//                    + ExitStatus.get(exitCode)
                    + Symbols.termination(exitCode);

            // escape trailing $ to prevent unexpected behavior (jumping back cursor), see:
            // https://stackoverflow.com/questions/37424743/sometimes-cursor-jumps-to-start-of-line-in-bash-prompt

            // wrapping correctly:
            // https://unix.stackexchange.com/questions/105958/terminal-prompt-not-wrapping-correctly

        } catch (Error | Exception e) {
            prompt = "[prompt error]$ ";
        }

        return prompt;
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--version")) {
            System.out.println("prompt-0.0.1-SNAPSHOT-20210630");
            System.out.println("https://github.com/arthurpicht/prompt-java");
            System.exit(0);
        }
        String exitCode = args.length > 0 ? args[0] : "";
        System.out.println(prompt(exitCode));
    }

}

