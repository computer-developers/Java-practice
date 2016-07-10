package stack;
public class Stack{
     private int t=-1;
     private Queue q1,q2;
     public Stack(int x){
          q1=new Queue(x);
     }
     public Stack(){
          q1=new Queue();
     }
     public boolean push(int x){
          boolean f;
          t++;
          if(!(f=q1.insert(x)))
               t--;
          return f;
     }
     public String toString(){
          return q1.toString();
     }
     public int pop(){
          if(t==-1)
               throw new ArithmeticException();
          q2=new Queue(q1.length());
          for(int i=0;i<t;i++)
               q2.insert(q1.delete());
          int x=q1.delete();
          t--;
          q1=q2;
          q2=null;
          return x;
     }
}
