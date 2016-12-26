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
     private class SymUpdate{
          private eboard EArr[]=Arrays.copyOfRange(eboard.getAll(),0,2);
          //eboard arr[]={_O,_X};
          private int c=0;
          eboard update(){
               c=(c+1)%EArr.length;
               return EArr[c];
          }
          eboard get(){
               return EArr[c];
          }
     }
     SymUpdate su=new SymUpdate();
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
          io.setConsumer((s)->func(io,s));
          new Thread(io::start).start();
          iomap[j]=io;
          return io.getPipedInputStream();
     }
     public void func(IOMap pl,String s){
         // System.out.println("ser func :- "+s);
          String arr[]=s.split(" ",2);
          switch(arr[0]){
               case Move:
                    System.out.println(arr[1]);
                    move(pl,arr[1]);
                    break;
               case Details:
                    System.out.println(arr[1]);
                    detail(pl,arr[1]);
                    break;
          }
     }
     synchronized private void move(IOMap p,String s){
          if(p.getSym()==_N){
               p.putMessage(Board_Error+" "+BE_Sym);
               return;
          }
          String arr[]=s.split(CC,2);
          if(!p.getSym().name().equals(arr[0]))
               return;
          if(!p.getSym().equals(su.get()))
               return;
          if(board.upDate(Integer.parseInt(arr[1].trim()),eboard.valueOf(arr[0].trim())))
               updateAll(Board_Status+" "+makeBS_Run(su.update()));
          updateAll(Board_Update+" "+board.display());
          try{
               if(board.check()!=_N)
                    updateAll(Board_Status+" "+makeBS_win(board.check(),board.getWin()));
          }catch(NoMoveException e){
               updateAll(Board_Status+" "+BS_Draw);
          }
     }
     synchronized private void detail(IntPlayer pl,String s){
          pl.setName(getDetail(s).getName());
          pl.setSym(getDetail(s).getSym());
          updateAll(Board_Detail+" "+pl.getSym()+SC+pl.getName());
     }
     private void updateAll(String s){
          for(IOMap i:iomap)
               try{
                    i.putMessage(s);
               }catch(ArrayIndexOutOfBoundsException e){}
     }
}
