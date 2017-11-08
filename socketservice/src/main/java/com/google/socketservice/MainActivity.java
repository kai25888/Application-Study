package com.google.socketservice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tiankai on 2017/11/8.
 */
public class MainActivity extends Activity {
    @Bind(R.id.socket_service_TCP)
    Button socketService;
    @Bind(R.id.socket_service_UDP)
    Button socketServiceUDP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.socket_service_TCP)
    public void onsocket_service_TCP_Clicked() {
        System.out.println("MainActivity TCP OnClick");
        new ServiceThreadTCP().start();
    }

    @OnClick(R.id.socket_service_UDP)
    public void onsocket_service_UDP_Clicked() {
        System.out.println("MainActivity UDP OnClick");
        new ServiceThreadUDP().start();
    }

    /**
     * TCP ServerSocket
     */
    private class ServiceThreadTCP extends Thread {
        ServerSocket serversocket = null;
        InputStream inputstream = null;

        @Override
        public void run() {
            try {
                serversocket = new ServerSocket(4567);
                //accept 是阻塞方法
                Socket socket = serversocket.accept();
                InputStream inputstream = socket.getInputStream();

                byte[] buffer = new byte[4 * 1024];
                int temp = 0;
                while ((temp = inputstream.read(buffer)) != -1) {
                    System.out.println(new String(buffer, 0, temp));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    serversocket.close();
                    if (inputstream != null)
                        inputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * UDP DatagramSocket
     */
    private class ServiceThreadUDP extends Thread{
        @Override
        public void run() {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(4567);
                byte[] data = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
                //receive 是阻塞方法
                datagramSocket.receive(datagramPacket);
                //获取1024 字节数据
                System.out.println(new String(datagramPacket.getData()));
                //实际获取数据
                String string = new String(datagramPacket.getData(),datagramPacket.getOffset(),datagramPacket.getLength());
                System.out.println(string);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

