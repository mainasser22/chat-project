/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_side;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import operation.Operation;

/**
 *
 * @author Nasser
 */
public class calculator extends UnicastRemoteObject implements Operation{
   calculator()throws RemoteException
    {
        
    }
    @Override
    public int sum(int x, int y) throws RemoteException {
    return x+y;
    }

    @Override
    public int sub(int x, int y) throws RemoteException {
    return x-y;    
    }

    @Override
    public int mul(int x, int y) throws RemoteException {
     return x*y;
    }

    @Override
    public int div(int x, int y) throws RemoteException {
    return x/y;
    }
    
}
