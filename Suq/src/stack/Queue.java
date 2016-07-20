package stack;
import interfaces.IntQueue;
class Queue implements IntQueue{
     private int a[],f=-1,r=-1;
     Queue(){
          a=new int[5];
     }
     Queue(int x){
          a=new int[x];
     }
     final synchronized public boolean insert(int x){
          synchronized(this){
               if(r>=a.length-1)
                    return false;
               a[++r]=x;
               if(r==0)
                    f=0;
          }
          return true;
     }
     final synchronized public int delete(){
          if(f>r)
               throw new ArithmeticException();
          synchronized(this){
               return a[f++];
          }
     }
     public String toString(){
          String x=new String();
          for(int i=0;i<=r;i++)
               x=x.concat(Integer.toString(a[i])+" ");
          return x;
     }
     int length(){
          return a.length;
     }
}
