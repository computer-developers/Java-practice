package game;
import java.util.Arrays;
import player.*;
public class GameData{
     private eboard board[][]=new eboard[3][3];
     private Player po,px;
     private String win=new String();
     public static int getind(int a,int b){
          return a*3+b;
     }
     public static int getrow(int a){
          return a/3;
     }
     public static int getcol(int a){
          return a%3;
     }
     public GameData(){
          for(int i=0;i<3;i++)
          Arrays.fill(board[i],eboard._N);
     }
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
     public String toString(){
          return Arrays.toString(board[0])+Arrays.toString(board[1])+Arrays.toString(board[2]);
     }
     public boolean upDate(int p,eboard s){
          if(board[getrow(p)][getcol(p)]!=eboard._N)
               return false;
          board[getrow(p)][getcol(p)]=s;
          try{
               po.upDate(p,s);
               px.upDate(p,s);
          }catch(Exception e){}
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
          for(int i=0;i<3;i++)r:{
               if(board[i][0].c=='N')
                    break r;
               for(int j=0;j<3;j++){
                    win=win.concat(Integer.toString(GameData.getind(i,j)));
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
     public Player getplayer(eboard e)throws InvalidSymbolException{
          if(e==eboard._O)
               return po;
          else if(e==eboard._X)
               return px;
          else
               throw new InvalidSymbolException();
     }
     public String getWin(){
          return win;
     }
}
