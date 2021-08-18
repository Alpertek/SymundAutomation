package com.symund.utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class Network {

    public static String localIpAddress(){
        String ipAddress="";
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ipAddress;
    }
}
