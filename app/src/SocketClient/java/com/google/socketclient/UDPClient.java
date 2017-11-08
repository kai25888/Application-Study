package com.google.socketclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by tiankai on 2017/11/8.
 */
public class UDPClient {
    public static void transfer(String[] args){
        try {
            DatagramSocket datagramSocket = new DatagramSocket(4567);
            InetAddress ip = InetAddress.getByName("192.168.1.104");
            String str = "Hello World!";
            byte[] data = str.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length,ip,4567);
            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
