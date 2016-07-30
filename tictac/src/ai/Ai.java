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
          ArrayList arr;
          arr=s.getavail();
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return;
          //for(Object o:arr)System.out.println("bL1 "+o);
          L1:{
               for(int i=0;i<arr.size();i++){
                    int k=(int)arr.get(i);
                    if(s.getstatus(GameData.getrow(k),GameData.getcol(k),e)>1){
                         System.out.println("move 1 "+i+" "+s.o.get(i));
                         if(move(k))
                              return;
                    }}
               for(int i=0;i<arr.size();i++){
                    int k=(int)arr.get(i);
                    if(s.getstatus(GameData.getrow(k),GameData.getcol(k),e.oppo())>1){
                         System.out.println("move 2 "+k+" "+s.x.get(k));
                         if(move(k))
                              return;
                    }}
          }
          //for(Object o:arr)System.out.println("bL2 "+o);
          L2:{
               Analysis an=new Analysis();
               ArrayList ar;
               ar=an.mindiff(s,super.e);
               //System.out.println(arr.size());
               //for(Object ob:arr)System.out.println("before re "+ob);
               arr.retainAll(ar);
               /*int b=arr.size()-1;
               //for(Object ob:arr)System.out.println("ai "+ob);
               if(b==0)
                    if(move((int)arr.get(b)))
                         return;
               if(b>0){
                    for(;true;)
                    if(move((int)arr.get(r.nextInt(b))))
                         return;
                    //System.out.println("svvsvvsvsvsvsvsv "+b);
               }*/
               
          }
          for(Object o:arr)System.out.println("bL3 "+o);
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return;
          L3:{
               Analysis an=new Analysis();
               ArrayList ar=an.nextStep(s,super.e);
               arr.retainAll(ar);
               /*if(arr.size()==1)
                    if(move((int)ar.get(0)))
                         return;
               //int b=ar.size()-1;*/
               //Analysis an=new Analysis();
          }
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return;
          for(Object o:arr)System.out.println("final "+o);
          int b=arr.size()-1;
          for(int i=r.nextInt(b);true;i=r.nextInt(b)){
               int k=(int)arr.get(i);
               if(s.getstatus(GameData.getrow(k),GameData.getcol(k), e)!=-1){
                         //System.out.println("move 3 "+i+" "+s.x.get(k)+" "+s.o.get(k));
                    if(move(k))
                         return;
               }
          }  
     }
     public void upDate(int x,eboard e){
          s.set(GameData.getrow(x),GameData.getcol(x),e);
     }
}