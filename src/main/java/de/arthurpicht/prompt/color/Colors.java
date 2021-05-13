package de.arthurpicht.prompt.color;

import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;

public class Colors {

    public static final AnsiFormat greenText = new AnsiFormat(Attribute.GREEN_TEXT(), Attribute.BOLD());
    public static final AnsiFormat redText = new AnsiFormat(Attribute.RED_TEXT(), Attribute.BOLD());
    public static final AnsiFormat blueText = new AnsiFormat(Attribute.BLUE_TEXT(), Attribute.BOLD());
    public static final AnsiFormat yellowText = new AnsiFormat(Attribute.YELLOW_TEXT(), Attribute.BOLD());


}
