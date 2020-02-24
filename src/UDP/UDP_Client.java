package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @file UDP_Client.java
 * @date Feb 24, 2020 , 13:23:46
 * @author Muhammet Alkan
 */
public class UDP_Client {

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 44444;

        new UDP_Client().start(host, port);
    }

    private void start(String host, int port) throws Exception {
        // client soketi oluşturma (ip ve port numarası DatagramPacket'e yazılacak)
        DatagramSocket socket = new DatagramSocket();

        // gönderilecek mesajı byte dizisine çevirmemiz gerekiyor
        String message = "Merhaba !";
        byte[] data = message.getBytes();

        // gönderilecek veri, verinin boyutu, alıcının adresi ve port numarası
        InetAddress address = InetAddress.getByName(host);
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

        // oluşturulan DatagramPacket'i server'a gönder
        socket.send(packet);
        System.out.println("Mesaj gönderildi : " + message);
    }
}
