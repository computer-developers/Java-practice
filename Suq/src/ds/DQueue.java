package ds;
import interfaces.*;
public class DQueue extends Queue implements IntDQueue{
     public int deleter(){
          if(f>r||f==-1)
               throw new ArithmeticException();
          synchronized(this){
               return a[r--];
          }
     }
     public boolean insertf(int x){
          synchronized(this){
               if(f==-1)
                    return super.insert(x);
               if(f==0)
                    if(r==a.length-1)
                         return false;
                    else{
                         for(int i=r+1;i>0;i--)a[i]=a[i-1];
                         r++;
                         f=1;
                    }
               a[--f]=x;
          }
          return true;
     }
}
