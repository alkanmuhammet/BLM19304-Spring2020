package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @file UDP_Server.java
 * @date Feb 24, 2020 , 13:24:00
 * @author Muhammet Alkan
 */
public class UDP_Server {

    public static void main(String[] args) throws Exception {
        int port = 44444;

        new UDP_Server().start(port);
    }

    private void start(int port) throws Exception {
        // server soketi oluşturma (sadece port numarası)
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("Server başlatıldı ..");
        
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        // blocking call, yeni bir DatagramPacket gelmesini bekler
        // gelen paketi yukarıda oluşturulan DatagramPacket'e yazar
        socket.receive(packet);

        // gönderilen String mesajını al (mesaj uzunluğu kadarını alır)
        // paket içerisindeki data boyutu daha fazla olabilir, sadece gereken kısmı alıyoruz
        String receivedMessage = new String(packet.getData(), 0, packet.getLength());

        System.out.println("received : " + receivedMessage);
    }
}
