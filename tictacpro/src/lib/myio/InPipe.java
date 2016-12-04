package lib.myio;
import java.io.*;
public class InPipe {
     public static InPipe newInPipe(int size){
          InPipe a=new InPipe();
                    a.in=new PipedInputStream(size);
          return a;
     }
     private PipedInputStream in;
     private ObjectInputStream ob;
     private InPipe(){}
     synchronized String getMessage(){
          Object x=null;
          try{
               if(ob==null)
                    ob=new ObjectInputStream(in);
               x=ob.readObject();
          }catch(IOException | ClassNotFoundException ex){
               System.err.println(ex);
               ex.printStackTrace();
          }
          if(x instanceof String){
               return (String)x;
          }
          return null;
     }
     synchronized Object getObject(){
          Object x=null;
          try{
               if(ob==null)
                    ob=new ObjectInputStream(in);
               x=ob.readObject();
          }catch(IOException | ClassNotFoundException ex){
               System.err.println(ex);
               ex.printStackTrace();
          }
          return x;
     }
     PipedInputStream getPipe(){
          if(in!=null)
               return in;
          throw new NullPointerException("sfsfsf");
     }
}

     /*private volatile boolean isempty;
     public boolean isEmpty(){
          return isempty;
     }*/