package ai;
import game.*;
import java.util.Random;
public class Ai{
     final GameData board;
     eboard e;
     Random r=new Random();
     Status s=new Status();
     public Ai(GameData board,eboard e){
          this.board=board;
          this.e=e;
     }
     public Ai(eboard e){
          board=new GameData();
          this.e=e;
     }
     public void move(){
          for(int i=0;i<9;i++)
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i),e)==2){
                    board.upDate(i,e);
                    break;
               }
          for(int i=0;i<9;i++)
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i),eboard._X)==2){
                    board.upDate(i,e);
                    break;
               }
          for(int i=r.nextInt(8);true;i=r.nextInt(8)){
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i), e)!=-1){
                    board.upDate(i, e);
                    break;
               }
          }
     }
}