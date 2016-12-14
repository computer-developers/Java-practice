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
import java.io.*;
import java.util.Arrays;
public class SerTwoPlayer {
     eboard EArr[]=Arrays.copyOfRange(eboard.getAll(),0,2);
     int c=0;
     int d=2;
     //eboard arr[]={_O,_X};
     GameData board=new GameData(3);
     IOMap[] iomap=new IOMap[2];
     public PipedInputStream setPlayer(IntInPipe i,IntPlayer p){
          int j;
          for(j=0;j<iomap.length-1&&iomap[j]!=null;j++);
          if(iomap[j]!=null)
               return null;
          IOMap io=new IOMap();
          io.addPlayer(p);
          io.createInPipe(1000);
          io.setOutPipe(i);
          io.setConsumer((s)->func(io.getPlayer(),s));
          new Thread(io::start).start();
          iomap[j]=io;
          return io.getPipedInputStream();
     }
     public void func(IntPlayer pl,String s){
         // System.out.println("ser func :- "+s);
          String arr[]=s.split(" ",2);
          switch(arr[0]){
               case Move:
                    System.out.println(arr[1]);
                    move(pl,arr[1]);
                    break;
          }
     }
     synchronized private void move(IntPlayer p,String s){
          String arr[]=s.split(CC,2);
          if(!p.getSym().name().equals(arr[0]))
               return;
          if(!p.getSym().equals(EArr[c]))
               return;
          //System.out.println("ssdda "+eboard.valueOf(arr[0])+" "+Integer.parseInt(arr[1]));
          board.upDate(Integer.parseInt(arr[1].trim()),eboard.valueOf(arr[0].trim()));
          c=(c+1)%d;
          System.out.println(" gmfhhfhh");
          for(IOMap i:iomap){
               i.putMessage(Board_Update+" "+board.display());
          }
          try{
               if(board.check()!=_N)
                    for(IOMap i:iomap){
                         i.putMessage(Board_Status+" "+makeBS_win(board.check(),board.getWin()));
                    }           
          }catch(NoMoveException e){}

                   
     }
}
