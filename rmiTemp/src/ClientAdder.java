import java.rmi.*;
import java.util.*;
public class ClientAdder {
     static String url;
     public static void main(String... arg){
          url="rmi://"+(arg.length==0?"localhost":arg[0])+":"+(arg.length<=1?"8686":arg[1])+"/my";
          try{
               Scanner sc=new Scanner(System.in);
               IntAdder adder=(IntAdder)Naming.lookup(url);
               System.out.println("url :- "+url);
               System.out.println("result = "+adder.add(sc.nextInt(),sc.nextInt()));
          }catch(Exception e){
               System.out.println(e);
               e.printStackTrace();
          }
          
     }
}
