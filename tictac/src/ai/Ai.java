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
     public Ai(String name,GameData board,eboard e) throws InvalidSymbolException{
          super(name,board,e);
     }
     public Ai(eboard e) throws InvalidSymbolException{
          super("Artificial Intelligence",new GameData(),e);
     }
     
     public int move(){
          ArrayList arr;
          arr=s.getavail();
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return (int)arr.get(0);
          L1:{
               for(int i=0;i<arr.size();i++){
                    int k=(int)arr.get(i);
                    if(s.getstatus(GameData.getrow(k),GameData.getcol(k),e)>1){
                         if(move(k))
                              return k;
                    }}
               for(int i=0;i<arr.size();i++){
                    int k=(int)arr.get(i);
                    if(s.getstatus(GameData.getrow(k),GameData.getcol(k),e.oppo())>1){
                         if(move(k))
                              return k;
                    }}
          }
          L2:{
               Analysis an=new Analysis();
               ArrayList ar;
               ar=an.mindiff(s,super.e);
               arr.retainAll(ar);
          }
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return (int)arr.get(0);
          L3:{
               Analysis an=new Analysis();
               ArrayList ar=an.nextStep(s,super.e);
               arr.retainAll(ar);
          }
          L4:{
               Analysis an=new Analysis();
               ArrayList ar=an.checkone(arr, s, e);
               arr.retainAll(ar);
          }
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return (int)arr.get(0);
          int b=arr.size()-1;
          for(int i=r.nextInt(b);true;i=r.nextInt(b)){
               int k=(int)arr.get(i);
               if(s.getstatus(GameData.getrow(k),GameData.getcol(k), e)!=-1){
                    if(move(k))
                         return k;
               }
          }  
     }
     public void upDate(int x,eboard e){
          s.set(GameData.getrow(x),GameData.getcol(x),e);
     }
}