package game;
import java.util.Arrays;
public class GameData{
     public static int getind(int a,int b){
          return a*3+b;
     }
     public static int getrow(int a){
          return a/3;
     }
     public static int getcol(int a){
          return a%3;
     }
     private eboard board[][]=new eboard[3][3];
     public GameData(){
          for(int i=0;i<3;i++)
          Arrays.fill(board[i],eboard._N);
     }
     public String toString(){
          return Arrays.toString(board[0])+Arrays.toString(board[1])+Arrays.toString(board[2]);
     }
     public int upDate(int p,eboard s){
          board[p/3][p%3]=s;
          System.out.println(toString()+check());
          System.out.println(display());
          return 1;
     }
     public String display(){
          String s=new String();
          for(eboard e[]:board)
               for(eboard d:e)
                    s=s.concat(Character.toString(d.c));
          return s;
     }
     eboard check(){
          for(int i=0;i<3;i++)r:{
               if(board[i][0].c=='N')
                    break r;
               for(int j=0;j<3;j++)
                    if(board[i][0]!=board[i][j])
                         break r;
               return board[i][0];
          }
          for(int j=0;j<3;j++)c:{
               if(board[0][j].c=='N')
                    break c;
               for(int i=0;i<3;i++)
                    if(board[0][j]!=board[i][j])
                         break c;
               return board[0][j];
          }
          if(board[1][1].c=='N'){
               d:{
                    for(int i=0;i<3;i++)
                         if(board[i][i].c!=board[1][1].c)
                              break d;
                    return board[1][1];
               }
               rd:{
                    for(int i=0;i<3;i++)
                         if(board[i][2-i].c!=board[1][1].c)
                              break rd;
                    return board[1][1];
               }
          }
          return eboard._N;
     }
}