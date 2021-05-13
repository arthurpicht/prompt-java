package de.arthurpicht.prompt.color;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import de.arthurpicht.prompt.Config;

public class Color {

    private static final char PROMPT_PREFIX = 1;
    private static final char PROMPT_POSTFIX = 2;

    public static String colorize(String string, AnsiFormat ansiFormat) {
        if (!Config.isColorize()) return string;

        return
                PROMPT_PREFIX +
                        Ansi.generateCode(ansiFormat) +
                        PROMPT_POSTFIX +
                        string +
                        PROMPT_PREFIX +
                        Ansi.RESET +
                        PROMPT_POSTFIX;
    }

}
