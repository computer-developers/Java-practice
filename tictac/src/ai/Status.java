package ai;
import game.*;
import java.util.Hashtable;
import java.util.ArrayList;
class Status{
     Hashtable<Integer,Integer>x,o;
     ArrayList<Integer>u;
     Status(){
          x=new Hashtable<Integer,Integer>();
          o=new Hashtable<Integer,Integer>();
          u=new ArrayList<Integer>();
     }
     void update(int p,eboard e){
          if(u.contains(p))
               return;
          if(e.c=='X'){
               if(x.containsKey(p))
                    x.replace(p,x.get(p)+1);
               else
                    x.put(p,1);
          }
          else if(e.c=='O'){
               if(o.containsKey(p))
                    o.replace(p,o.get(p)+1);
               else
                    o.put(p,1);
          }
          else{
               x.remove(p);
               o.remove(p);
          }
     }
     void set(int x,int y,eboard e){
          update(GameData.getind(x, y),eboard._N);
          u.add(GameData.getind(x, y));
          for(int i=x-1;i>=0;i--)update(GameData.getind(i,y),e);
          for(int i=x+1;i<=2;i++)update(GameData.getind(i,y),e);
          for(int i=y-1;i>=0;i--)update(GameData.getind(x,i),e);
          for(int i=y+1;i<=2;i--)update(GameData.getind(x,i),e);
          if(x==y){
               for(int i=x-1;i>=0;i--)update(GameData.getind(i,i),e);
               for(int i=x+1;i<=2;i++)update(GameData.getind(i,i),e);
          }
          if(x+y==2){
               for(int i=x-1;i>=0;i--)update(GameData.getind(i,2-i),e);
               for(int i=x+1;i<=2;i++)update(GameData.getind(i,2-i),e);
          }
     }
     int getstatus(int a,int b,eboard e){
          if(u.contains(GameData.getind(a, b)))
               return -1;
          if(e.c=='X'){
               if(x.containsKey(GameData.getind(a, b)))
                    return x.get(GameData.getind(a, b));
               else 
                    return 0;
          }
          if(e.c=='O'){
               if(o.containsKey(GameData.getind(a, b)))
                    return o.get(GameData.getind(a, b));
               else 
                    return 0;
          }
          return -2;
     }
}