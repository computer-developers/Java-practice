package lib.myio;
import java.io.*;
public class OutPipe {
     public static OutPipe newOutPipe(PipedInputStream in){
          OutPipe a=new OutPipe();
          try{ 
               a.out=new PipedOutputStream(in);
               a.ob=new ObjectOutputStream(a.out);
          }catch(IOException ex){
               return null;
          }
          return a;
     }
     PipedOutputStream out;
     private ObjectOutputStream ob;
     private volatile boolean isempty;
     synchronized boolean putMessage(String msg){
          try{
               ob.writeObject(msg);
          }catch(IOException ex){
               System.err.println(ex);
               ex.printStackTrace();
               return false;
          }
          return true;
     }
     synchronized boolean putObject(Object obj){
          try{
               ob.writeObject(obj);
          }catch(IOException ex){
               System.err.println(ex);
               ex.printStackTrace();
               return false;
          }
          return true;
     }
}

     /*private OutPipe(){}
     public boolean isEmpty(){
          return isempty;
     }*/