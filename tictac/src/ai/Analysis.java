package ai;
import game.GameData;
import game.eboard;
import java.util.ArrayList;
public class Analysis {
     int getdiff(int i,Status s,eboard e){
          int c=0;
               Status z=(Status)s.clones();
               boolean b=z.contain(eboard._N, i);
               if(z.contain(eboard._N,i)){
                    z.set(GameData.getrow(i),GameData.getcol(i),e);
                    /*for(int j=0;j<9;j++){                        
                         System.out.println(z.o.get(j)+" / "+z.x.get(j)+" / "+z.contain(e.oppo(),j));
                    }*/
                    for(int j=0;j<9;j++)
                         if(z.contain(e.oppo(),j))
                              if(!z.contain(e,j)){
                                   c++;
                                  // System.out.println("count "+c);
                              }
                    //System.out.println("getd "+i+" "+c+" "+b);
                    return c;
               }
               return -1;
     }
     public ArrayList mindiff(Status s,eboard e){
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
//          System.out.println("mind "+arr.get(0));
          return arr;
     }
}
