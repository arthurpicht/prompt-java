package de.arthurpicht.prompt.formattedChunks;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import de.arthurpicht.prompt.Config;
import de.arthurpicht.prompt.info.InfrastructureFile;

public class Infrastructure {

    public static String get() {
        String infrastructure = InfrastructureFile.get();
        return getString(infrastructure);
    }

    private static String getString(String infrastructure) {
        if (infrastructure == null || infrastructure.equals("")) return "";
        infrastructure = "[" + infrastructure + "]";
        if (Config.isColorize()) {
//            return Ansi.colorize(infrastructure, Attribute.BRIGHT_WHITE_TEXT(), Attribute.RED_BACK());
            return Ansi.colorize(infrastructure, Attribute.RED_TEXT());
        } else {
            return infrastructure;
        }
    }

}
