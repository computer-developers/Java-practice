package client.cliplayer;
import java.io.*;
import lib.modules.gameboard.*;
import lib.modules.player.*;
import lib.myio.*;
import static lib.modules.message.ServerMessage.*;
import static lib.modules.message.ClientMessage.*;
public class CLIPlayer implements IntInPipe{
     private IOManager io;
     private String name="Default Name";
     private eboard sym;
     private PrintStream out=System.out;
     @Override
     public PipedInputStream getPipedInputStream() {
          if(io!=null)
               return io.getPipedInputStream();
          return null;
     }
     public CLIPlayer(String name,eboard sym){
          this.sym=sym;
          this.name=name;
          io=new IOManager(name);
          io.createInPipe(200);
     }
     public void init(){
          io.setConsumer(this::fun);
          new Thread(() -> io.start()).start();
     }
     public void fun(String s){
          System.out.println(name+" :- "+s);
          String [] arr=s.split(" ",2);
          switch(arr[0]){
               case Board_Update:
                    out.println(arr[1]);
                    break;
               case Board_Status:
                    if(arr[1].split("@",3)[0]==BS_Win){
                         out.println("win :- "+arr[1]);
                         return;
                    }
                    break;
          }
     }
     public void server(PipedInputStream i){
          io.setOutPipe(()->i);
     }
     public void input(int x){
          io.putMessage(Move+" "+sym.name()+CC+Integer.toString(x));
     }
}
