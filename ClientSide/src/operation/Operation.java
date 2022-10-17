/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import java.rmi.RemoteException;

/**
 *
 * @author Nasser
 */
public interface Operation {
    public int sum(int x,int y) throws RemoteException;
    public int sub(int x,int y) throws RemoteException;
    public int mul(int x,int y) throws RemoteException;
    public int div(int x,int y) throws RemoteException;
}
