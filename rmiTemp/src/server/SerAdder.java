package server;
import java.rmi.server.*;
import java.rmi.*;
import rmitemp.*;
public class SerAdder extends UnicastRemoteObject implements IntAdder{

     public SerAdder()throws RemoteException{}
     
     @Override
     public int add(int x, int y) throws RemoteException{
          System.out.println(x+y);
          return x+y;
     }
     
}
