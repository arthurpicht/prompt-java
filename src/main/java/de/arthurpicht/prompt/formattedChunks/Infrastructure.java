package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.InfrastructureFile;

public class Infrastructure {

    public static String get() {
        try {
            String infrastructure = InfrastructureFile.get();
            return getString(infrastructure);
        } catch (Error | Exception e) {
            return "";
        }
    }

    private static String getString(String infrastructure) {
        if (infrastructure == null || infrastructure.equals("")) return "";
        infrastructure = "[" + infrastructure + "]";
        return Color.colorize(infrastructure, Colors.yellowText);
    }

}
