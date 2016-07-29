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
          L1:{
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
          }
          L3:{
               Analysis an=new Analysis();
               ArrayList ar=an.nextStep(s,super.e);
               if(ar.size()==1)
                    if(move((int)ar.get(0)))
                         return;
               //int b=ar.size()-1;
               /*for(int i=r.nextInt(b);true;i=r.nextInt(b)){
                    if(s.getstatus(GameData.getrow(i),GameData.getcol(i), e)!=-1){
                         //System.out.println("move 3 "+i+" "+s.x.get(i)+" "+s.o.get(i));
                         if(move(i))
                              return;
                    }
               }*/  
               //Analysis an=new Analysis();
               ArrayList arr=an.mindiff(s,super.e);
               //System.out.println(arr.size());
               for(Object ob:arr)System.out.println("before re "+ob);
               arr.retainAll(ar);
               int b=arr.size()-1;
               for(Object ob:arr)System.out.println("ai "+ob);
               if(b==0)
                    if(move((int)arr.get(b)))
                         return;
               if(b>0){
                    for(;true;)
                    if(move((int)arr.get(r.nextInt(b))))
                         return;
                    //System.out.println("svvsvvsvsvsvsvsv "+b);
               }
          }
     }
     public void upDate(int x,eboard e){
          s.set(GameData.getrow(x),GameData.getcol(x),e);
     }
}