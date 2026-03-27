package com.example.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(5000);

            System.out.println("[server] waiting");
            Socket socket = ss.accept();
            System.out.println("[server] connected");

            InputStream in = socket.getInputStream();
            InputStreamReader ir = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(ir);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String line = br.readLine();
                System.out.println("[server]: " + line);
                pw.println("ok");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
