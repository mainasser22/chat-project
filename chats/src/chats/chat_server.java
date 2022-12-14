
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;

/**
 *
 * @author Nasser
 */
public class chat_server extends javax.swing.JFrame {

    static ServerSocket ss;
    static Socket link;
    static DataInputStream din;
    static DataOutputStream dout;
    public chat_server() {
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

        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });
        getContentPane().add(msg_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 480, 40));

        msg_send.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        msg_send.setText("Send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });
        getContentPane().add(msg_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 80, 40));

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 570, 320));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel1.setText("Server");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chats/chat4.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_textActionPerformed

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
         try {
            String msgout = ""; //?????? ?????? ???????????????? ?? ????msgout ?????? ???????????? ???????? ?????????? ???? ???? textfield
            msgout = msg_text.getText().trim(); // ?????????? ????text ???????? ?????? ?????????? ???? ???? textfield ????
            //?????????? ?????? ?????? ???????? ???????? ?????????????? ???? dataoutputstream
            dout.writeUTF(msgout + "\n"); //sending the server message to the client
            msg_area.append("Server:" + msgout + "\n");
            msg_text.setText("");
            //JOptionPane.showMessageDialog(null,"Message has been sent"); 
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }//GEN-LAST:event_msg_sendActionPerformed

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
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_server().setVisible(true);
            }
        });
        String msgin = "";
        try {
            ss = new ServerSocket(1201); //get port number(server waits(listens)at 1201 port number)
            link = ss.accept();  //the server accepts the client's request(accepts the connection)
            din = new DataInputStream(link.getInputStream()); //ready to receive data(input)from the client
            dout = new DataOutputStream(link.getOutputStream());  //ready to send data(output)to the client
            while (!msgin.equals("exit")) // ?????? ???? ?????????????? ???????????? ???? exit ?????? ???????? ???????????? ???? ????client
            { //?????? ???????????? ?????? ?????? ???????? ?????? ????data input stream ???????? ???? ????din ???????? ?????? ???????????????? ??????
                msgin = din.readUTF(); //???????? ???????????? ???? ?????????????? ???????? ???????? ???? ???? ?????????????????????????? ???? ????msgin 
                //?? ???????????? ?????? ?????? ???????? ???????????? ???? ???? msg_area
                //  msg_area.setText(msgin);  ???? ???????????? ?????? ???????????? ?????????????? ?????????????? ???????????? ???????????????? ???? ???? ???????? ?????????????? ???????? ???? ???????? ?????? ?????? ???????? ?????????????? ??????????
                msg_area.setText(msg_area.getText().trim() + "\n Client:" + msgin); //???????? ???????????? ?????????? ?????????? ???????? ?????? ?????????? ????????????
            }
     
        } catch (Exception e) {
            System.out.println("Error");
        }
        /*try{
            System.out.println("Waiting");
            Registry r=LocateRegistry.createRegistry(12345);
            calculator calculator=new calculator();
            r.rebind("calc", calculator);
            System.out.println("Blinding complete....\n");
        }
       catch(RemoteException e){
           //e.printStackTrace();
       }*/
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}
