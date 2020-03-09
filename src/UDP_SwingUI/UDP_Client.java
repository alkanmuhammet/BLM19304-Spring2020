package UDP_SwingUI;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @file UDP_Client.java
 * @date Feb 24, 2020 , 13:23:46
 * @author Muhammet Alkan
 */
public class UDP_Client {

    private DatagramSocket clientSocket;
    private javax.swing.JTextPane historyJTextPane;
    private InetAddress address;
    private int port;
    private Thread clientThread;

    protected void start(String host, int port, javax.swing.JTextPane jTextPaneHistory, javax.swing.JLabel jLabelName) throws Exception {
        address = InetAddress.getByName(host);
        this.port = port;
        // client arayüzündeki history alanı, bütün olaylar buraya yazılacak
        this.historyJTextPane = jTextPaneHistory;

        // client soketi oluşturma (ip ve port numarası DatagramPacket'e yazılacak)
        clientSocket = new DatagramSocket();

        // server'ı sürekli dinlemek için Thread oluştur
        clientThread = new ListenThread();
        clientThread.start();

        // client arayüzündeki isim yazısı, local port numarasını isim olarak veriyoruz
        jLabelName.setText(clientSocket.getLocalPort() + "");
    }

    protected void writeToHistory(Object message) {
        // client arayüzündeki history alanına mesajı yaz
        historyJTextPane.setText(historyJTextPane.getText() + "\n" + message);
    }

    protected void sendMessage(String message) throws Exception {
        // gelen mesajı server'a gönder
        byte[] buf = message.getBytes();
        clientSocket.send(new DatagramPacket(buf, buf.length, address, port));
    }

    protected void sendObject(Object object) throws Exception {
        // gelen mesajı server'a gönder
        byte[] buf = convertToBytes(object);
        clientSocket.send(new DatagramPacket(buf, buf.length, address, port));
    }

    private byte[] convertToBytes(Object object) throws Exception {
        // parametre olarak alınan nesneyi byte dizisine çevirir
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    protected void stop() throws Exception {
        if (clientSocket != null) {
            clientSocket.close();
        }
    }

    class ListenThread extends Thread {

        // server'dan gelen mesajları dinle
        @Override
        public void run() {
            try {
                writeToHistory("Server'a bağlandı ..");

                byte[] data = new byte[1024];
                DatagramPacket packet = new DatagramPacket(data, data.length);

                while (true) {
                    // blocking call, yeni bir DatagramPacket gelmesini bekler
                    // gelen paketi yukarıda oluşturulan DatagramPacket'e yazar
                    clientSocket.receive(packet);

                    // gönderilen String mesajını al (mesaj uzunluğu kadarını alır)
                    // paket içerisindeki data boyutu daha fazla olabilir, sadece gereken kısmı alıyoruz
                    String receivedMessage = new String(packet.getData(), 0, packet.getLength());

                    writeToHistory(receivedMessage);

                    // "son" mesajı iletişimi sonlandırır
                    if (receivedMessage.equals("son")) {
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Error - ListenThread : " + ex);
            }
        }
    }
}
