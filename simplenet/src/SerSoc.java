import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SerSoc extends ServerSocket{
     Thread t;
     SerSoc() throws IOException{
          super(8686);
          t=new Thread(this::start);
          t.start();
     }
     void start(){
          for(;;){
               try {
                    new SerCon(this.accept());
               } catch(IOException ex) {

               }
          }
     }
     public static void main(String... arg){
          try {
               SerSoc ss=new SerSoc();
          } catch(IOException ex) {
          }
     }
}
