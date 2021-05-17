package de.arthurpicht.prompt.formattedChunks;

import com.diogonunes.jcolor.AnsiFormat;
import de.arthurpicht.prompt.Config;
import de.arthurpicht.prompt.color.Color;
import de.arthurpicht.prompt.color.Colors;
import de.arthurpicht.prompt.info.UserName;

public class Symbols {

    public static String whiteColon() {
        return getSign(":", Colors.whiteText);
    }

    public static String whiteAdd() {
        return getSign("@", Colors.whiteText);
    }

    public static String darkGreenAdd() {
        return getSign("@", Colors.darkGreenText);
    }

    public static String yellowDegree() {
        return getSign("°", Colors.yellowText);
    }

    private static String getSign(String sign, AnsiFormat ansiFormat) {
        if (!Config.isColorize()) return sign;
        return Color.colorize(sign, ansiFormat);
    }

    public static String upwardsArrowFromBar() {
        // http://xahlee.info/comp/unicode_arrows.html
        return getSign("\u21a5", Colors.yellowText);
    }

    public static String termination() {
        StringBuilder terminationSign = new StringBuilder();
        if (UserName.getUserName().equals("root")) {
            terminationSign.append(getSign("#", Colors.redText));
        } else {
            terminationSign.append(getSign("$", Colors.whiteText));
        }
        terminationSign.append(" ");

        return terminationSign.toString();
    }


}
