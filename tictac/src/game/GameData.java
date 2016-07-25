package game;
import java.util.Arrays;
public class GameData{
     private eboard board[]=new eboard[9];
     public GameData(){
          Arrays.fill(board,eboard._N);
     }
     public String toString(){
          return Arrays.toString(board);
     }
     public int upDate(int p,eboard s){
          board[p]=s;
          System.out.println(toString()+check());
          System.out.println(display());
          return 1;
     }
     public String display(){
          String s=new String();
          for(eboard e:board)s=s.concat(Character.toString(e.c));
          return s;
     }
     eboard check(){
          for(int i=0;i<9;i+=3)
               if(board[i].c!='N')
                    if(board[i].v==board[i+1].v&&board[i].v==board[i+2].v)
                         return board[i];
          for(int i=0;i<3;i++)
               if(board[i].c!='N')
                    if(board[i].v==board[i+3].v&&board[i].v==board[i+6].v)
                         return board[i];
          if(board[0].c!='N')
               if(board[0].v==board[4].v&&board[0].v==board[8].v)
                    return board[0];
          if(board[2].c!='N')
               if(board[2].v==board[4].v&&board[2].v==board[6].v)
                    return board[2];
          return eboard._N;
     }
}