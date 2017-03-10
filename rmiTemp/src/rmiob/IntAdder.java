package rmiob;


import java.rmi.*;
public interface IntAdder extends Remote{
     int add(int x,int y)throws RemoteException;
     MyClass getOb()throws RemoteException;
}
