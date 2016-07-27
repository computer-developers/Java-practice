package ai;
import game.*;
import player.*;
import java.util.Random;
public class Ai extends Player{
     Random r=new Random();
     Status s=new Status();
     public Ai(GameData board,eboard e) throws InvalidSymbolException{
          super("Artificial Intelligence",board,e);
     }
     public Ai(eboard e) throws InvalidSymbolException{
          super("Artificial Intelligence",new GameData(),e);
     }
     public void move(){
          for(int i=0;i<9;i++)
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i),e)==2){
                    if(move(i))
                         break;
               }
          for(int i=0;i<9;i++)
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i),eboard._X)==2){
                    if(move(i))
                         break;
               }
          for(int i=r.nextInt(8);true;i=r.nextInt(8)){
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i), e)!=-1){
                    if(move(i))
                         break;
               }
          }
     }
     public void upDate(int x,eboard e){
          s.set(GameData.getrow(x),GameData.getcol(x),e);
     }
}