package de.arthurpicht.dynamicPrompt.info;

public class WorkingDir {

    public static String getWorkingDir() {
//        Path currentPath = Paths.get("");
//        return currentPath.toAbsolutePath().toString();

        String userDir = System.getProperty("user.dir");
        String userHome = System.getProperty("user.home");
        if (userDir != null && !userDir.equals("")) {
            if (userDir.startsWith(userHome)) {
                userDir = userDir.replaceFirst(userHome, "~");
            }
            return userDir;
        }
        return "?";
    }

}
