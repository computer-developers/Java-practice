package ds;
import interfaces.IntQueue;
public class Queue implements IntQueue{
     protected int a[],f=-1,r=-1;
     Queue(){
          a=new int[5];
     }
     Queue(int x){
          a=new int[x];
     }
     final synchronized public boolean insert(int x){
          synchronized(this){
               if(r>=a.length-1)
                    if(f==0)
                         return false;
                    else
                    {
                         for(int i=0;i<=(r-f);i++)a[i]=a[i+f];
                         r=r-f;
                         f=0;
                    }
               a[++r]=x;
               if(r==0)
                    f=0;
          }
          return true;
     }
     final synchronized public int delete(){
          if(f>r||f==-1)
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
