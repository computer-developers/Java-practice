package ai;
import game.GameData;
import game.eboard;
import java.util.ArrayList;
public class Analysis {
     int getdiff(int i,final Status s,eboard e){
          int c=0;
               Status z=(Status)s.clones();
               if(z.contain(eboard._N,i)){
                    z.set(GameData.getrow(i),GameData.getcol(i),e);
                    for(int j=0;j<9;j++)
                         if(z.contain(e.oppo(),j))
                              if(!z.contain(e,j)){
                                   c++;
                              }
                    return c;
               }
               return -1;
     }
     public ArrayList mindiff(final Status s,eboard e){
          ArrayList arr=new ArrayList();
          int coun=9;
          for(int i=0;i<9;i++){
               int f=getdiff(i,s,e);
               if(f!=-1&&f<coun){
                    arr.clear();
                    arr.add(i);
                    coun=f;
               }
               else if(f==coun)
                    arr.add(i);
          }
          return arr;
     }
     public ArrayList nextStep(final Status s,eboard e){
          ArrayList arr=new ArrayList();
          for(int i=0;i<9;i++)
               if(s.contain(eboard._N,i))
                    arr.add(i);
          arr=checktwo(arr,s,e);
          return arr;
     }
     ArrayList checktwo(ArrayList arr,Status s,eboard e){
          ArrayList rem=new ArrayList();
          for(int i=0;i<arr.size();i++){
               int f=(int)arr.get(i);
               Status z=(Status)s.clones();
               if(z.contain(eboard._N,f)){
                    z.set(GameData.getrow(f),GameData.getcol(f),e);
                    for(int j=0;j<9;j++)
                         if(z.getstatus(GameData.getrow(j),GameData.getcol(j),e)>1)
                              if(z.movenum(j,e.oppo())>1){
                                   rem.add(f);
                         }
               }
          }
          arr.removeAll(rem);
          return arr;
     }
}
