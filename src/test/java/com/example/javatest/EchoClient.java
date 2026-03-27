package com.example.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("[Client] Connected to server");

            // 키보드 입력 받는 부분
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader keyboard = new BufferedReader(isr);

            // 서버에서 데이터 받는 부분
            InputStream is = socket.getInputStream();
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);

            // 서법로 데이터 보내는 부분
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            String input;

            while (true) {
                // 키보드 입력 받기
                input = keyboard.readLine();

                // 서버로 보내기
                pw.println(input);

                // 서버가 보낸 데이터 받기
                String response = br.readLine();
                System.out.println("[Server] " + response);

                if (input.equals("exit")) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
