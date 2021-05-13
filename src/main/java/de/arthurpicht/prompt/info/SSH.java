package de.arthurpicht.prompt.info;

import java.util.Map;

public class SSH {

    public static boolean isSshConnection() {
        // https://unix.stackexchange.com/questions/9605/how-can-i-detect-if-the-shell-is-controlled-from-ssh
        // cave: this works not for "su -"
        Map<String, String> env = System.getenv();
        return env.containsKey("SSH_TTY") || env.containsKey("SSH_CONNECTION") || env.containsKey("SSH_CLIENT");
    }

}
