package server;
import java.rmi.*;
import java.rmi.registry.*;
import rmitemp.*;
public class MyServer {
     public static void main(String... arg){
          try{
               IntAdder adder = new SerAdder();
               Naming.rebind("rmi://localhost:8686/my", adder);
          }catch(Exception e){
               
          }
     }
}
