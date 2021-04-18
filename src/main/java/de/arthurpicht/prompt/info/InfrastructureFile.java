package de.arthurpicht.prompt.info;

import de.arthurpicht.prompt.helper.ExceptionHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InfrastructureFile {

    public static String get() {

        Path infrastructure = Paths.get("/etc/infrastructure");

        if (Files.exists(infrastructure)) {
            try {
                return Files.readString(infrastructure).trim();
            } catch (IOException e) {
                ExceptionHandler.handle(e);
                return "";
            }
        }

        return "";
    }

}
