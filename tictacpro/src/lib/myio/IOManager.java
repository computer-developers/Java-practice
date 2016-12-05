package lib.myio;
import java.io.*;
import java.util.function.*;
import java.util.*;
import static lib.myio.InPipe.*;
import static lib.myio.OutPipe.*;
public class IOManager implements IntInPipe {
     public static final String robj="Request_Object",aobj="AKG_Object";
     private String name="Default_name";
     private InPipe in;
     private OutPipe out;
     private volatile boolean f=false;
     private Consumer<String> cn;
     public IOManager(String name){
          this.name=name;
     }
     public IOManager(){}
     public void createInPipe(int x){
          in=newInPipe(x);
//          if(in==null)
//               System.out.println("zfqio");
     }
     public void setOutPipe(IntInPipe pi){
          out=newOutPipe(pi.getPipedInputStream());
     }
     public void setConsumer(Consumer<? super String>cn){
          this.cn=s->cn.accept(s);
     }
     private void getMessage(){
          String s=null;
          synchronized(in){
               s=in.getMessage();
          }
          //System.out.println("io getmsg "+s);
          cn.accept(s.split(" ",2)[1]);
          //cn.accept(s);
     }
     public Object getObject(String msg){
          synchronized(in){
                    putMessage(robj+" "+msg);
                    Object o;
                    for(int i=0;i<5;i++){
                         o=in.getObject();
                         if(o instanceof String){
                              try{
                                   String s=new String((String)o);
                                   String arr[]=s.split(" ",3);
                                   if(arr[1]==aobj){
                                        if(arr[2]==msg)
                                             return in.getObject();
                                   }else
                                        cn.accept((String)o);
                              }catch(ArrayIndexOutOfBoundsException ex){
                                   cn.accept((String)o);
                              }
                         }
                    }
          }
          System.err.println("requested object not received msg := "+msg);
          return null;
     }
     public void putMessage(String s){
          synchronized(out){
               out.putMessage(name+" "+s);
          }
     }
     public void start(){
          f=true;
          for(;f;){
               getMessage();
          }
     }
     public void stop(){
          f=false;
     }
     @Override
     public PipedInputStream getPipedInputStream() {
//          if(in==null)
//               System.out.println("jnfhkjh");
          return in.getPipe();
     }
}
