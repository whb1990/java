package main.java.com.study.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author: whb
 * @date: 2019/10/14 10:22
 * @description: 传统的IO方式实现的客户端
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + "：hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {

                    }
                }
            } catch (IOException e) {

            }
        }).start();
    }
}
