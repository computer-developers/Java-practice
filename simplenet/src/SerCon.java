import java.io.*;
import java.net.Socket;

public class SerCon{
     Socket soc;
     Thread t;
     ObjectOutputStream o;
     ObjectInputStream in;
     SerCon(Socket s){
          soc=s;
          t=new Thread(this::func);
          t.start();
     }
     void func(){
          for(;;){
               try{
                    if(in==null)
                         in=new ObjectInputStream(soc.getInputStream());
                    String s=(String)in.readObject();
                    System.out.println(s);
                    if(o==null)
                         o=new ObjectOutputStream(soc.getOutputStream());
                    o.writeObject(s);
               }catch(Exception e){
               }
          }
     }
}
