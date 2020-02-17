package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @file TCP_Client.java
 * @date Feb 17, 2020 , 13:07:59
 * @author Muhammet Alkan
 */
public class TCP_Client {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 44444;

        new TCP_Client().start(host, port);
    }

    private void start(String host, int port) throws IOException {
        // client soketi oluşturma (ip + port numarası)
        Socket socket = new Socket(host, port);

        // input  : client'a gelen mesajları okumak için
        // output : client'dan bağlı olduğu server'a mesaj göndermek için
        Scanner input = new Scanner(socket.getInputStream());
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        // client konsoldan servera mesaj gönderebilir
        System.out.print("Mesaj gönder : ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // konsoldan mesaj oku
            String mesaj = scanner.nextLine();
            // konsoldan yazılan mesajı server'a gönder
            output.println(mesaj);
            // server'dan gelen cevabı konsola yaz
            System.out.println(input.nextLine());

            // "son" mesajı iletişimi sonlandırır
            if (mesaj.equals("son")) {
                break;
            }

            System.out.print("Mesaj gönder : ");
        }
    }
}
