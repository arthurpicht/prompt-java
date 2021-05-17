package de.arthurpicht.prompt.info;

import de.arthurpicht.prompt.helper.ExceptionHandler;
import de.arthurpicht.prompt.helper.InputStreamHelper;

import java.io.IOException;
import java.util.List;

public class ExitStatusOfLastCommand {

    public static String get() {
//        try {
            String exitStatus = System.getenv("?");
            if (exitStatus == null) return "";
            return exitStatus;


//            Process process = new ProcessBuilder("bash", "-c", "echo $?").start();
//            List<String> result = InputStreamHelper.asStringList(process.getInputStream());
//            if (process.waitFor() > 0) return "error";
//            if (result.size() > 0) {
//                return result.get(0);
//            }
//            return "other";
//        } catch (IOException | InterruptedException e) {
//            ExceptionHandler.handle(e);
//            return "exception";
//        }
    }

}
