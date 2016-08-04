package ai;
import game.*;
import java.util.Hashtable;
import java.util.ArrayList;
class Status implements Cloneable{
     final static int r=1000,c=100,d=10,rd=1;
     Hashtable<Integer,Integer>x,o;
     Hashtable<Integer,eboard>u;
     Status(){
          x=new Hashtable<Integer,Integer>();
          o=new Hashtable<Integer,Integer>();
          u=new Hashtable<Integer,eboard>();
     }
     void update(int p,int h,eboard e){
          if(u.containsKey(p))
               return;
          if(e.c=='X'){
               if(x.containsKey(p))
                    x.replace(p,x.get(p)+h);
               else
                    x.put(p,h);
          }
          else if(e.c=='O'){
               if(o.containsKey(p))
                    o.replace(p,o.get(p)+h);
               else
                    o.put(p,h);
          }
          else{
               x.remove(p);
               o.remove(p);
          }
     }
     void set(int x,int y,eboard e){
          update(GameData.getind(x, y),10,eboard._N);
          u.put(GameData.getind(x, y),e);
          for(int i=x-1;i>=0;i--)update(GameData.getind(i,y),c,e);
          for(int i=x+1;i<=2;i++)update(GameData.getind(i,y),c,e);
          for(int i=y-1;i>=0;i--)update(GameData.getind(x,i),r,e);
          for(int i=y+1;i<=2;i++)update(GameData.getind(x,i),r,e);
          if(x==y){
               for(int i=x-1;i>=0;i--)update(GameData.getind(i,i),d,e);
               for(int i=x+1;i<=2;i++)update(GameData.getind(i,i),d,e);
          }
          if(x+y==2){
               for(int i=x-1;i>=0;i--)update(GameData.getind(i,2-i),rd,e);
               for(int i=x+1;i<=2;i++)update(GameData.getind(i,2-i),rd,e);
          }
     }
     int getstatus(int a,int b,eboard e){
          if(u.containsKey(GameData.getind(a, b)))
               return -1;
          if(e.c=='X'){
               if(x.containsKey(GameData.getind(a, b))){
                    int k=x.get(GameData.getind(a, b)),n=0;
                    for(;k>0;k=k/10)
                         if(k%10>n)n=k%10;
                    return n;
               }
               else 
                    return 0;
          }
          if(e.c=='O'){
               if(o.containsKey(GameData.getind(a, b))){
                    int k=o.get(GameData.getind(a, b)),n=0;
                    for(;k>0;k=k/10)
                         if(k%10>n)n=k%10;
                    return n;
               }
               else 
                    return 0;
          }
          return -2;
     }
     public boolean contain(eboard e,int i){
          if(e.c=='X')
               return x.containsKey(i);
          else if(e.c=='O')
               return o.containsKey(i);
          else
               return !u.containsKey(i);
     }
     protected Object clones(){
          Status f=new Status();
          try{
               f.x.putAll(this.x);
               f.o.putAll(this.o);
               f.u.putAll(this.u);
          }catch(Exception e){System.out.println("clone error");}
          return f;
     }
     int movenum(int i,eboard e){
          int p,j;
          if(e.c=='X'){
               if(x.containsKey(i)){
                    p=x.get(i);
                    for(j=0;p>0;p/=10)
                         if(p%10!=0)j++;
                    return j;
               }
               else
                    return 0;
          }
          else if(e.c=='O'){
               if(o.containsKey(i)){
                    p=o.get(i);
                    for(j=0;p>0;p/=10)
                         if(p%10!=0)j++;
                    return j;
               }
               else
                    return 0;
          }
          return -1;
     }
     ArrayList getavail(){
          ArrayList a=new ArrayList();
          for(int b=0;b<9;b++)a.add(b);
          a.removeAll(u.keySet());
          return a;
     }
}