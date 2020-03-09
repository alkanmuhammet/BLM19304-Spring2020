package UDP_SwingUI;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @file UDP_Server.java
 * @date Feb 24, 2020 , 13:24:00
 * @author Muhammet Alkan
 */
public class UDP_Server {

    private DatagramSocket serverSocket;
    private Thread serverThread;
    private javax.swing.JTextPane historyJTextPane;

    protected void start(int port, javax.swing.JTextPane jTextPaneHistory) throws Exception {
        // server arayüzündeki history alanı, bütün olaylar buraya yazılacak
        this.historyJTextPane = jTextPaneHistory;

        // server soketi (DatagramSocket) oluşturma (sadece port numarası)
        serverSocket = new DatagramSocket(port);
        System.out.println("Server başlatıldı ..");

        // DatagramPacket, gelen mesaj bu paket içerisine alınacak
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        serverThread = new Thread(() -> {
            while (true) {
                try {
                    // blocking call, yeni bir DatagramPacket gelmesini bekler
                    // gelen paketi yukarıda oluşturulan DatagramPacket'e yazar
                    serverSocket.receive(packet);

                    // gönderilen String mesajını al (mesaj uzunluğu kadarını alır)
                    // paket içerisindeki data boyutu daha fazla olabilir, sadece gereken kısmı alıyoruz
                    String receivedMessage = new String(packet.getData(), 0, packet.getLength());

                    writeToHistory(packet.getSocketAddress() + " received : " + receivedMessage);
                } catch (Exception ex) {
                    System.out.println("Hata - new Thread() : " + ex);
                    break;
                }
            }
        });
        serverThread.start();
    }

    protected void writeToHistory(String message) {
        // server arayüzündeki history alanına mesajı yaz
        historyJTextPane.setText(historyJTextPane.getText() + "\n" + message);
    }

    protected void stop() {
        if (serverSocket != null) {
            serverSocket.close();
        }
    }

    // TODO: send broadcast message to all clients
    protected void sendBroadcast(String message) throws Exception {

    }

}
