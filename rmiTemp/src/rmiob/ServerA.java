package rmiob;


import java.rmi.server.*;
import java.rmi.*;
public class ServerA extends UnicastRemoteObject implements IntAdder{

     public ServerA()throws RemoteException{}
     
     @Override
     public int add(int x, int y) throws RemoteException{
          System.out.println(x+y);
          return x+y;
     }

     @Override
     public MyClass getOb() throws RemoteException{
          MyClass m=new MyClass();
          m.printPath();
          return m;
     }
     
}
