package ai;
import game.*;
import player.*;
import java.util.*;
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
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i),e)>1){
                    //System.out.println("move 1 "+i+" "+s.o.get(i));
                    if(move(i))
                         return;
               }
          for(int i=0;i<9;i++)
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i),e.oppo())>1){
                    //System.out.println("move 2 "+i+" "+s.x.get(i));
                    if(move(i))
                         return;
               }
               Analysis an=new Analysis();
               ArrayList arr=an.mindiff(s,super.e);
               System.out.println(arr.size());
               int b=arr.size()-1;
               if(b==0)
                    if(move((int)arr.get(b)))
                         return;
               if(b>0){
                    b=r.nextInt(b);
                    //System.out.println("svvsvvsvsvsvsvsv "+b);
                    if(move((int)arr.get(b)))
                         return;
               }
          for(int i=r.nextInt(8);true;i=r.nextInt(8)){
               if(s.getstatus(GameData.getrow(i),GameData.getcol(i), e)!=-1){
                    //System.out.println("move 3 "+i+" "+s.x.get(i)+" "+s.o.get(i));
                    if(move(i))
                         return;
               }
          }
     }
     public void upDate(int x,eboard e){
          s.set(GameData.getrow(x),GameData.getcol(x),e);
     }
}