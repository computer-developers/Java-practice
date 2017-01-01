import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.net.*;
public class MyServer {
     static String uri;
     static Scanner sc=new Scanner(System.in);
     public static void main(String... arg) throws Exception{
          uri="rmi://localhost:"+(arg.length==0?"8686":arg[0])+"/my";
          System.out.println("enter 0 to stop server");
          new Thread(MyServer::startSer).start();
          System.out.println("url :- rmi://"+InetAddress.getLocalHost().getHostAddress()+"/my");
          for(;sc.nextInt()!=0;);
          System.exit(0);
     }
     public static void startSer(){
          try{
               IntAdder adder = new ServerA();
               Naming.rebind("rmi://localhost:8686/my", adder);
          }catch(Exception e){
               e.printStackTrace();
               
          }
     }
}
