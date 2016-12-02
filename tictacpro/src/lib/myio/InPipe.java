package lib.myio;
import java.io.*;
public class InPipe {
     public static InPipe newInPipe(int size){
          InPipe a=new InPipe();
          for(;;){
               try{ 
                    a.in=new PipedInputStream(size);
            //        if(a.in!=null)
                    a.ob=new ObjectInputStream(a.in);
                    break;
               }catch(IOException ex){
                    System.out.println("InPipe cna not be intialized...");
                    return null;
               }
          }
          return a;
     }
     private PipedInputStream in;
     private ObjectInputStream ob;
     private InPipe(){}
     synchronized String getMessage(){
          Object x=null;
          try{
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