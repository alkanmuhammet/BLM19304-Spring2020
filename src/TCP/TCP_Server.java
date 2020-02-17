package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @file TCP_Server.java
 * @date Feb 17, 2020 , 12:28:55
 * @author Muhammet Alkan
 */
public class TCP_Server {

    public static void main(String[] args) throws IOException {
        int port = 44444;

        new TCP_Server().start(port);
    }

    private void start(int port) throws IOException {
        // client soketi oluşturma (sadece port numarası)
        ServerSocket socket = new ServerSocket(port);
        System.out.println("Server başlatıldı ..");

        while (true) {
            // blocking call, yeni bir client bağlantısı bekler
            Socket clientSocket = socket.accept();

            System.out.println("Yeni bir client bağlandı : " + clientSocket);
            // bağlanan her client için bir thread oluşturup dinlemeyi başlatır
            new ListenThread(clientSocket).start();
        }
    }

    class ListenThread extends Thread {

        // dinleyeceğimiz client'ın soket nesnesi
        private final Socket socket;

        private ListenThread(Socket clientSocket) {
            this.socket = clientSocket;
        }

        @Override
        public void run() {
            System.out.println("Bağlanan client için thread oluşturuldu : " + this.getName());

            try {
                // input  : client'dan gelen mesajları okumak için
                // output : server'a bağlı olan client'a mesaj göndermek için
                Scanner input = new Scanner(socket.getInputStream());
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // client mesaj gönderdiği sürece
                while (input.hasNextLine()) {
                    // client'in gönderdiği mesaj
                    String mesaj = input.nextLine();
                    System.out.println(this.getName() + " : " + mesaj);

                    // client'a gönderilen mesaj
                    output.println("alındı : " + mesaj);

                    // "son" mesajı iletişimi sonlandırır
                    if (mesaj.equals("son")) {
                        break;
                    }
                }

            } catch (IOException ex) {
                System.out.println("Hata : " + ex);
            } finally {
                try {
                    socket.close();
                    System.out.println("Soket kapatıldı : " + socket);
                } catch (IOException ex) {
                    System.out.println("Soket kapatılamadı : " + ex);
                }
            }
        }
    }
}
