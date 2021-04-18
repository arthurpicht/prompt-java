package de.arthurpicht.prompt.info;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostName {

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknownHost";
        }
    }


}
