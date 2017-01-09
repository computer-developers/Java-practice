import java.io.*;
import java.io.*;
import java.net.*;
import java.util.*;
public class ClientSoc extends Socket implements AutoCloseable{
     Thread ti,to;
     String name="default";
     boolean b=false;
     static Scanner sca=new Scanner(System.in);
     ObjectOutputStream o;
     ObjectInputStream in;
     ClientSoc(String s) throws IOException{
          super("localhost",8686);
          start();
          if(s!=null)
               name=s;
     }
     void start(){
          to=new Thread(this::funout);
          ti=new Thread(this::funin);
          to.start();
          ti.start();
     }
     void funout(){
          int i=0;
          for(;;){
               try{
                    Thread.sleep(1000);
                    if(this.isClosed())
                         return;
                    if(o==null)
                         o=new ObjectOutputStream(this.getOutputStream());
                    o.writeObject(name+" :- "+i++);
                    b=true;
               }catch(Exception e){}
               
          }
     }
     void funin(){
          int i=0;
          for(;;){
               try{
                    if(!b){
                         Thread.sleep(1000);
                         continue;
                    }
                    if(this.isClosed())
                         return;
                    if(in==null)
                         in=new ObjectInputStream(this.getInputStream());
                    System.out.println("Recived :- "+in.readObject());
               }catch(Exception e){}
          }
     }
     void stop(){
          if(ti!=null&&ti.isAlive())
               ti.stop();
          if(to!=null&&to.isAlive())
               to.stop();
     }
     public static void main(String...arg) throws IOException{
          ClientSoc cs=new ClientSoc(sca.nextLine());
     }
}
