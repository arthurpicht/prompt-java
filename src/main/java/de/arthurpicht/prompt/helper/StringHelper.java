package de.arthurpicht.prompt.helper;

public class StringHelper {

    public static String getLastWord(String line) {
        if (line == null || line.equals("")) throw new IllegalArgumentException("Parameter 'line' is null or empty.");
        line = line.trim();
        if (line.equals("")) throw new IllegalArgumentException("Parameter 'line' is only white space.");
        int lastSpaceIndex = line.lastIndexOf(' ');
        if (lastSpaceIndex < 0) return line;
        return line.substring(lastSpaceIndex + 1);
    }

}
