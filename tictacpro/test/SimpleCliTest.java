import server.*;
import client.cliplayer.*;
import lib.modules.gameboard.*;
import lib.modules.player.*;
import java.util.*;
public class SimpleCliTest {
     public static void main(String... arg){
          Scanner sc=new Scanner(System.in);
          SerTwoPlayer ser=new SerTwoPlayer();
          CLIPlayer p1=new CLIPlayer("Px",eboard._X);
          IntPlayer ip1=SimplePlayer.getSP("Px").setSym(eboard._X);
          CLIPlayer p2=new CLIPlayer("Po",eboard._O);
          IntPlayer ip2=SimplePlayer.getSP("Po").setSym(eboard._O);
          p2.server(ser.setPlayer(p2, ip2));
          p1.server(ser.setPlayer(p1, ip1));
          p1.init();
          p2.init();
          boolean f=false;
          for(;;){
               if(f){
                    System.out.println("px :- ");
                    p1.input(sc.nextInt());
               }else{
                    System.out.println("po :- ");
                    p2.input(sc.nextInt());
               }
               f=!f;         
          }
     }
}

