package suq;
import java.util.Scanner;
import ds.Stack;
public class Suq {
     static Scanner a=new Scanner(System.in);
     public static void main(String[] args){
          Stack s;
          int x;
          System.out.println("Enter size of stack...");
          x=a.nextInt();
          s=new Stack(x);
          for(;true;)
          switch (menu()){
               case 1:System.out.print("Enter element..");
                    if(!s.push(a.nextInt()))
                         System.out.println("Element can not be inserted.");          
                    else
                         System.out.println("Element inserted succesfully.");
                    break;
               case 2:try{
                         System.out.println(s.pop()+" has been deleted.");
                    }catch(ArithmeticException e){
                         System.out.println("element can not be deleted from Stack");
                    }break;
               case 3:System.out.println(s);break;
               case 0:return;
               default : System.out.println("invalid choice!!");
          }
     }
     Suq(){
         String a[]={""};
         Suq.main(a);
     }
     static int menu(){
          System.out.println("Menu..");
          System.out.println("1.push");
          System.out.println("2.delete");
          System.out.println("3.display");
          System.out.println("0.exit");
          return a.nextInt();
     }
}