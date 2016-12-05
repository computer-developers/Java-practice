package server;
import lib.modules.IOMap;
import lib.modules.gameboard.*;
import lib.modules.player.*;
import static lib.modules.player.SimplePlayer.*;
import static lib.modules.gameboard.eboard.*;
import static lib.modules.message.ClientMessage.*;
import static lib.modules.message.ServerMessage.*;
import lib.modules.*;
import lib.myio.*;
import java.util.Hashtable;
import java.io.*;
public class SerTwoPlayer {
     GameData board=new GameData(3);
     IOMap iomap=new IOMap(2);
     public PipedInputStream setPlayer(IntInPipe i,IntPlayer p){
          IOManager io=new IOManager(p.getName());
          if(!iomap.add(io,p))
               return null;
          io.createInPipe(1000);
          io.setOutPipe(i);
          io.setConsumer(this::func);
          new Thread(io::start).start();
          return io.getPipedInputStream();
     }
     public void func(String s){
         // System.out.println("ser func :- "+s);
          String arr[]=s.split(" ",2);
          switch(arr[0]){
               case Move:
                    System.out.println(arr[1]);
                    move(arr[1]);
                    break;
          }
     }
     synchronized private void move(String s){
          String arr[]=s.split(CC,2);
         // System.out.println("ssdda "+eboard.valueOf(arr[0])+" "+Integer.parseInt(arr[1]));
          board.upDate(Integer.parseInt(arr[1].trim()),eboard.valueOf(arr[0].trim()));
         // System.out.println(" gmfhhfhh");
          for(IntPlayer p:iomap.getAllPlayer()){
               iomap.getIO(p).putMessage(Board_Update+" "+board.display());
          }
          try{
               if(board.check()!=_N)
                    for(IntPlayer p:iomap.getAllPlayer()){
                         iomap.getIO(p).putMessage(Board_Status+" "+makeBS_win(board.check(),board.getWin()));
                    }           
          }catch(NoMoveException e){}
     }
}
