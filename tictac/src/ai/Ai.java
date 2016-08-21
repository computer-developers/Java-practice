package ai;
import game.*;
import player.*;
import java.util.*;
public class Ai extends Player{
     public static int L_Easy=1,L_Mid=2,L_High=3;
     private int level=3;
     Random r=new Random();
     Status s=new Status();
     public Ai(GameData board,eboard e) throws InvalidSymbolException{
          this("Artificial Intelligence",board,e);
     }
     public Ai(String name,GameData board,eboard e) throws InvalidSymbolException{
          this(name,board,e,L_High);
     }
     public Ai(eboard e) throws InvalidSymbolException{
          this("Artificial Intelligence",new GameData(),e);
     }
     public Ai(String name,GameData board,eboard e,int level) throws InvalidSymbolException{
          super(name,board,e);
          this.level=level;
     }
     public Ai(GameData board,eboard e,int level) throws InvalidSymbolException{
          this("Artificial Intelligence",board,e,level);
     }
     public Ai(eboard e,int level) throws InvalidSymbolException{
          this("Artificial Intelligence",new GameData(),e,level);
     }
     public int move(){
          ArrayList arr;
          arr=s.getavail();
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return (int)arr.get(0);
          if(arr.size()==9){
               int i=(int)arr.get(r.nextInt(8));
               if(move(i))
                    return i;
          }
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
          L2:if(level/2>=1){
               Analysis an=new Analysis();
               ArrayList ar;
               ar=an.mindiff(s,board,super.e);
               arr.retainAll(ar);
          }
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return (int)arr.get(0);
          L3:if(level/3>=1){
               Analysis an=new Analysis();
               ArrayList ar=an.nextStep(s,super.e);
               arr.retainAll(ar);
          }
          L4:if(level/3>=1){
               Analysis an=new Analysis();
               ArrayList ar=an.checkone(arr, s, e);
               arr.retainAll(ar);
          }
          if(arr.size()==1)
               if(move((int)arr.get(0)))
                    return (int)arr.get(0);
          if(arr.size()==0)
               board.check();
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