import lib.modules.gameboard.*;
import java.util.*;
import static lib.modules.gameboard.eboard.*;
public class GameDataTest {
     static int i=-1;
     static int size=4;
     public static void main(String... arg)
     {
          Scanner sc=new Scanner(System.in);
          GameData g=new GameData(4);
          for(;;){
               try{
                    System.out.println(g.display());
                    g.upDate(sc.nextInt(),sel());
                    System.out.println("check : "+g.check());
                    System.out.println("win : "+g.getWin());
               }catch(Exception e){
                    System.out.println(e);
                    e.printStackTrace();
               }
          }
     }
     static eboard sel(){
          i++;
          switch(i%=size){
               case 0:return _O;
               case 1:return _X;
               case 2:return _T;
               case 3:return _S;
          }
          return _N;
     }
}
