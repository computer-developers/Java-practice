import server.*;
import client.cliplayer.*;
import lib.modules.gameboard.*;
import lib.modules.player.*;
import java.util.*;
public class SimpleCliTest {
     public static void main(String... arg) throws InterruptedException{
          Scanner sc=new Scanner(System.in);
          SerTwoPlayer ser=new SerTwoPlayer();
          CLIPlayer p1=new CLIPlayer("P1",eboard._N);
          IntPlayer ip1=SimplePlayer.getSP("P1").setSym(eboard._N);
          CLIPlayer p2=new CLIPlayer("P2",eboard._N);
          IntPlayer ip2=SimplePlayer.getSP("P2").setSym(eboard._N);
          p2.server(ser.setPlayer(p2, ip2));
          p1.server(ser.setPlayer(p1, ip1));
          p1.init();
          p2.init();
          boolean f=false;
          for(;;){
               Thread.sleep(100);
               synchronized(Scanner.class){   
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
}

