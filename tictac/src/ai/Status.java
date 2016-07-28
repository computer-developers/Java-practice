package ai;
import game.*;
import java.util.Hashtable;
import java.util.ArrayList;
class Status implements Cloneable{
     final static int r=1000,c=100,d=10,rd=1;
     Hashtable<Integer,Integer>x,o;
     ArrayList<Integer>u;
     Status(){
          x=new Hashtable<Integer,Integer>();
          o=new Hashtable<Integer,Integer>();
          u=new ArrayList<Integer>();
     }
     void update(int p,int h,eboard e){
          if(u.contains(p))
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
          u.add(GameData.getind(x, y));
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
          if(u.contains(GameData.getind(a, b)))
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
               return !u.contains(i);
     }
     protected Object clones(){
          Status f=new Status();
          try{
               f.x.putAll(this.x);
               f.o.putAll(this.o);
               f.u.addAll(this.u);
               /*for(int j=0;j<9;j++){
                    System.out.println(f.o.get(j)+" "+f.x.get(j));
               }
               System.out.println("t");*/
          }catch(Exception e){System.out.println("clone error");}
          return f;
     }
}