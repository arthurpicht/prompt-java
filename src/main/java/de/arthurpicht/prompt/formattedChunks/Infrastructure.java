package de.arthurpicht.prompt.formattedChunks;

import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.InfrastructureFile;

public class Infrastructure {

    public static String get() {
        String infrastructure = InfrastructureFile.get();
        return getString(infrastructure);
    }

    private static String getString(String infrastructure) {
        if (infrastructure == null || infrastructure.equals("")) return "";
        infrastructure = "[" + infrastructure + "]";
        return Color.colorize(infrastructure, Colors.redText);
    }

}
