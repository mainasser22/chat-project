/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_side;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Nasser
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
            System.out.println("Waiting");
            Registry r=LocateRegistry.createRegistry(2244);
            calculator calculator=new calculator();
            r.rebind("calc", calculator);
            System.out.println("Blinding complete....\n");
        }
       catch(RemoteException e){
           e.printStackTrace();
       }
    }
    
}
