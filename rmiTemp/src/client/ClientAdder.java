package client;
import java.rmi.*;
import rmitemp.*;
import java.util.*;
public class ClientAdder {
     public static void main(String... arg){
          try{
               Scanner sc=new Scanner(System.in);
               System.out.println("fafff");
               IntAdder adder=(IntAdder)Naming.lookup("rmi://localhost:8686/my");
               System.out.println("result = "+adder.add(sc.nextInt(),sc.nextInt()));
          }catch(Exception e){
               System.out.println(e);
               e.printStackTrace();
          }
          
     }
}
