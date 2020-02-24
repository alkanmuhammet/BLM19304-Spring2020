/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_SwingUI;

import java.io.IOException;

/**
 *
 * @author Muhammet Alkan
 */
public class ClientUI extends javax.swing.JFrame {

    TCP_Client client;

    /**
     * Creates new form ServerUI
     */
    public ClientUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonConnect = new javax.swing.JButton();
        jButtonDisconnect = new javax.swing.JButton();
        jButtonSendMessage = new javax.swing.JButton();
        jTextFieldIP = new javax.swing.JTextField();
        jLabelIP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneHistory = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneMessage = new javax.swing.JTextPane();
        jLabelHistory = new javax.swing.JLabel();
        jTextFieldPort = new javax.swing.JTextField();
        jLabelPort = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jButtonSendObject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setResizable(false);

        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jButtonDisconnect.setText("Disconnect");
        jButtonDisconnect.setEnabled(false);
        jButtonDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisconnectActionPerformed(evt);
            }
        });

        jButtonSendMessage.setText("Send Message");
        jButtonSendMessage.setToolTipText("");
        jButtonSendMessage.setEnabled(false);
        jButtonSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendMessageActionPerformed(evt);
            }
        });

        jTextFieldIP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldIP.setText("localhost");
        jTextFieldIP.setToolTipText("Port Number");

        jLabelIP.setText("IP:");

        jTextPaneHistory.setEditable(false);
        jScrollPane1.setViewportView(jTextPaneHistory);

        jScrollPane2.setViewportView(jTextPaneMessage);

        jLabelHistory.setText("History:");

        jTextFieldPort.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPort.setText("44444");
        jTextFieldPort.setToolTipText("Port Number");

        jLabelPort.setText("Port:");

        jLabelName.setText("Client Name");

        jButtonSendObject.setText("Send Object");
        jButtonSendObject.setToolTipText("");
        jButtonSendObject.setEnabled(false);
        jButtonSendObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendObjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHistory)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelName)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonSendObject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonSendMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelIP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIP))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPort)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPort))
                            .addComponent(jButtonConnect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIP)
                    .addComponent(jButtonSendMessage)
                    .addComponent(jLabelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPort)
                    .addComponent(jButtonSendObject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHistory))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDisconnect)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        try {
            String host = jTextFieldIP.getText();
            int port = Integer.parseInt(jTextFieldPort.getText());

            client = new TCP_Client();
            client.start(host, port, jTextPaneHistory, jLabelName);

            disableConnectButton();
        } catch (IOException ex) {
            System.out.println("Error - jButtonConnectActionPerformed : " + ex);
            enableConnectButton();
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendMessageActionPerformed
        try {
            String message = jTextPaneMessage.getText();

            if (!message.isEmpty()) {
                // String mesaj gönder
                client.sendMessage(message);
                jTextPaneMessage.setText("");
            }

            if (message.equals("son")) {
                jButtonDisconnectActionPerformed(evt);
            }
        } catch (IOException ex) {
            System.out.println("Error - jButtonConnectActionPerformed : " + ex);
            enableConnectButton();
        }
    }//GEN-LAST:event_jButtonSendMessageActionPerformed

    private void jButtonDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisconnectActionPerformed
        try {
            client.disconnect();
            enableConnectButton();
        } catch (IOException ex) {
            System.out.println("Error - jButtonDisconnectActionPerformed : " + ex);
        }
    }//GEN-LAST:event_jButtonDisconnectActionPerformed

    private void jButtonSendObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendObjectActionPerformed
        try {
            String message = jTextPaneMessage.getText();

            if (!message.isEmpty()) {
                Mesaj mesajNesnem = new Mesaj();
                mesajNesnem.text = message;

                // nesne içerisinde mesajı gönder
                client.sendObject(mesajNesnem);

                jTextPaneMessage.setText("");
            }

            if (message.equals("son")) {
                jButtonDisconnectActionPerformed(evt);
            }
        } catch (IOException ex) {
            System.out.println("Error - jButtonConnectActionPerformed : " + ex);
            enableConnectButton();
        }
    }//GEN-LAST:event_jButtonSendObjectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonDisconnect;
    private javax.swing.JButton jButtonSendMessage;
    private javax.swing.JButton jButtonSendObject;
    private javax.swing.JLabel jLabelHistory;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextPane jTextPaneHistory;
    private javax.swing.JTextPane jTextPaneMessage;
    // End of variables declaration//GEN-END:variables

    private void disableConnectButton() {
        jButtonConnect.setEnabled(false);
        jButtonDisconnect.setEnabled(true);
        jButtonSendMessage.setEnabled(true);
        jButtonSendObject.setEnabled(true);
    }

    private void enableConnectButton() {
        jButtonConnect.setEnabled(true);
        jButtonDisconnect.setEnabled(false);
        jButtonSendMessage.setEnabled(false);
        jButtonSendObject.setEnabled(false);
    }
}
