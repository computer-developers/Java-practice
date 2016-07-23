package ds;
import interfaces.IntStack;
public class Stack implements IntStack{
     private int t=-1;
     private Queue q1,q2;
     public Stack(int x){
          q1=new Queue(x);
     }
     public Stack(){
          q1=new Queue();
     }
     final synchronized public boolean push(int x){
          boolean f;
          synchronized(q1){
               t++;
               if(!(f=q1.insert(x)))
                    t--;
          }
          return f;
     }
     public String toString(){
          return q1.toString();
     }
     final public int pop(){
          int x;
          synchronized(q1){
               if(t==-1)
                    throw new ArithmeticException();
               q2=new Queue(q1.length());
               synchronized(q2){     
                    for(int i=0;i<t;i++)
                         q2.insert(q1.delete());
                    x=q1.delete();
                    q1=q2;
               }
               q2=null;
               t--;
          }
          return x;
     }
}