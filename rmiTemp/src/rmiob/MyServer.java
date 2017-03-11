package rmiob;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.net.*;
public class MyServer {
     static String uri;
     static Scanner sc=new Scanner(System.in);
     public static void main(String... arg) throws Exception{
          int port=arg.length==0?8686:Integer.parseInt(arg[0]);
          Registry r=LocateRegistry.createRegistry(port);
          uri="rmi://localhost:"+port+"/my";
          System.out.println("enter 0 to stop server");
          //Process p=Runtime.getRuntime().exec("rmiregistry 8686");
          new Thread(MyServer::startSer).start();
          System.out.println("url :- rmi://"+InetAddress.getLocalHost().getHostAddress()+"/my");
          for(;sc.nextInt()!=0;);
          //p.destroyForcibly();
          System.exit(0);
     }
     public static void startSer(){
          try{
               IntAdder adder = new ServerA();
               Naming.rebind(uri, adder);
          }catch(Exception e){
               e.printStackTrace();
               
          }
     }
}
