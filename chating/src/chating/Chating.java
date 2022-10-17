/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chating;

/**
 *
 * @author Nasser
 */
public class Chating {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         chat_server s = new chat_server();
         s.setVisible(true);
         chat_client c = new chat_client();
          c.setVisible(true);
    }
    
}
