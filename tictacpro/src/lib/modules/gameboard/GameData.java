package lib.modules.gameboard;
import java.util.Arrays;
import static lib.modules.gameboard.eboard.*;
import lib.modules.player.*;
public class GameData{
     private int size;
     private eboard board[][];
     private IntPlayer po,px,pt,ps;
     private String win=new String();
     public static int getind(int a,int b,int size){
          return a*size+b;
     }
     public static int getrow(int a,int size){
          return a/size;
     }
     public static int getcol(int a,int size){
          return a%size;
     }
     public GameData(int size){
          this.size=size;
          board=new eboard[size][size];
          for(int i=0;i<size;i++)
          Arrays.fill(board[i],_N);
     }
     public boolean upDate(int p,eboard s){
          if(board[getrow(p,size)][getcol(p,size)]!=_N)
               return false;
          board[getrow(p,size)][getcol(p,size)]=s;
          return true;
     }
     public String display(){
          String s=new String();
          for(eboard e[]:board){
               for(eboard d:e)
                    s=s.concat(Character.toString(d.c));
               s=s.concat("\n");
          }     
          return s;
     }
     public eboard check()throws NoMoveException{
          boolean f=false;
          for(int i=0;i<size;i++){
               for(int j=0;j<size;j++){
                    r:try{//for row
                         if(board[i][j]==_N){
                              f=true;
                              break r;
                         }
                         eboard e=board[i][j];
                         win=""+getind(i,j,size);
                         for(int k=1;k<3;k++){
                              if(board[i][j+k]!=e)
                                   break r;
                              win+="_"+getind(i,j+k,size);
                         }
                         return e;
                    }catch(ArrayIndexOutOfBoundsException ex){
                         win=null;
                    }
                    win=null;
                    r:try{//for column
                         if(board[i][j]==_N){
                              f=true;
                              break r;
                         }
                         eboard e=board[i][j];
                         win=""+getind(i,j,size);
                         for(int k=1;k<3;k++){
                              if(board[i+k][j]!=e)
                                   break r;
                              win+="_"+getind(i+k,j,size);
                         }
                         return e;
                    }catch(ArrayIndexOutOfBoundsException ex){
                         win=null;
                    }
                    win=null;
                    r:try{//for diagonal
                         if(board[i][j]==_N){
                              f=true;
                              break r;
                         }
                         eboard e=board[i][j];
                         win=""+getind(i,j,size);
                         for(int k=1;k<3;k++){
                              if(board[i+k][j+k]!=e)
                                   break r;
                              win+="_"+getind(i+k,j+k,size);
                         }
                         return e;
                    }catch(ArrayIndexOutOfBoundsException ex){
                         win=null;
                    }
                    win=null;
                    r:try{//for reverse diagonal
                         if(board[i][j]==_N){
                              f=true;
                              break r;
                         }
                         eboard e=board[i][j];
                         win=""+getind(i,j,size);
                         for(int k=1;k<3;k++){
                              if(board[i+k][j-k]!=e)
                                   break r;
                              win+="_"+getind(i+k,j-k,size);
                         }
                         return e;
                    }catch(ArrayIndexOutOfBoundsException ex){
                         win=null;
                    }
                    win=null;
               }
          }
          if(!f)
               throw new NoMoveException();
          return _N;
     }
     public String getWin(){
          return win;
     }
     public boolean setPlayer(IntPlayer p){
          switch(p.getSym()){
               case _O:po=p;
                    return true;
               case _X:px=p;
                    return true;
               case _T:pt=p;
                    return true;
               case _S:ps=p;
                    return true;
               case _N:
                    return false;
               default:
                    assert false:"invalid Eboard Symbol";
          }
          assert false;
          return false;
     }
     public boolean removePlayer(IntPlayer p){
          switch(p.getSym()){
               case _O:if(p.equals(po)){
                         po=null;
                         return true;
                    }else return false;
               case _X:if(p.equals(px)){
                         px=null;
                         return true;
                    }else return false;
               case _T:if(p.equals(pt)){
                         pt=null;
                         return true;
                    }else return false;
               case _S:if(p.equals(ps)){
                         ps=null;
                         return true;
                    }else return false;
               case _N:
                    return false;
               default:
                    assert false:"invalid Eboard Symbol";
          }
          assert false;
          return false;
     }
     public IntPlayer getPlayer(eboard e){
          switch(e){
               case _O:
                    return po;
               case _X:
                    return px;
               case _T:
                    return pt;
               case _S:
                    return ps;
               case _N:
                    return null;
               default:
                    assert false:"invalid Eboard Symbol";
          }
          assert false;
          return null;
          
     }
}
/*
     public boolean setplayer(Player p){
          if(p.e==eboard._O){
               po=p;
               return true;
          }else if(p.e==eboard._X){
               px=p;
               return true;
          }
          return false;
     }
     public Player getplayer(eboard e)throws InvalidSymbolException{
          if(e==eboard._O)
               return po;
          else if(e==eboard._X)
               return px;
          else
               throw new InvalidSymbolException();
     }

     public eboard check()throws NoMoveException{
          for(int i=0;i<3;i++)r:{
               if(board[i][0].c=='N')
                    break r;
               for(int j=0;j<3;j++){
                    win=win.concat(Integer.toString(GameData.getind(i,j,size)));
                    if(board[i][0]!=board[i][j]){
                         win=new String();
                         break r;
                    }
               }     
               return board[i][0];
          }
          for(int j=0;j<3;j++)c:{
               if(board[0][j].c=='N')
                    break c;
               for(int i=0;i<3;i++){
                    win=win.concat(Integer.toString(GameData.getind(i,j)));
                    if(board[0][j]!=board[i][j]){
                         win=new String();
                         break c;
                    }
               }
               return board[0][j];
          }
          if(board[1][1].c!='N'){
               d:{
                    for(int i=0;i<3;i++){
                         win=win.concat(Integer.toString(GameData.getind(i,i)));
                         if(board[i][i].c!=board[1][1].c){
                              win=new String();
                              break d;
                         }
                    }
                    return board[1][1];
               }
               rd:{
                    for(int i=0;i<3;i++){
                         win=win.concat(Integer.toString(GameData.getind(i,2-i)));
                         if(board[i][2-i].c!=board[1][1].c){
                              win=new String();
                              break rd;
                         }
                    }
                    return board[1][1];
               }
          }
          for(int i=0;i<9;i++)
               if(board[GameData.getrow(i)][GameData.getcol(i)]==eboard._N)
                    return eboard._N;
          throw new NoMoveException("match draw");
     }

*/