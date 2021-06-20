package de.arthurpicht.prompt.info;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostName {

    public static String getHostName() {
        String host;
        try {
            host = InetAddress.getLocalHost().getHostName();
            if (host == null || host.isEmpty()) host = "?";
        } catch (UnknownHostException e) {
            host = "?";
        }
        return host;
    }

}
