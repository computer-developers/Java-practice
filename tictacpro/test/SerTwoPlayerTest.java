import lib.modules.player.SimplePlayer;
import server.*;
import lib.myio.*;
import lib.modules.player.*;
import lib.modules.gameboard.*;
public class SerTwoPlayerTest {
     public static void main(String... arg){
          SerTwoPlayer ser=new SerTwoPlayer();
          IOManager io1=new IOManager("io1");
          IOManager io2=new IOManager("io2");
          IntPlayer p1=SimplePlayer.getSP("p1").setSym(eboard._O);
          IntPlayer p2=SimplePlayer.getSP("p2").setSym(eboard._X);
          io1.createInPipe(1000);
          io2.createInPipe(1000);
          io1.setOutPipe(()->ser.setPlayer(io1, p1));
          io2.setOutPipe(()->ser.setPlayer(io2, p2));
          io1.setConsumer(s->System.out.println("io1 consum "+s));
          io2.setConsumer(s->System.out.println("io2 consum "+s));
          new Thread(io1::start).start();
          new Thread(io2::start).start();
          new Thread(()->{int i=0;
                              for(;;){
                                   io1.putMessage(""+i++);
                                   try{
                                        Thread.sleep(2000);
                                   }catch(InterruptedException e){}
                              }
                         }).start();
          new Thread(()->{int i=0;
                              for(;;){
                                   io2.putMessage(""+i++);
                                   try{
                                        Thread.sleep(2000);
                                   }catch(InterruptedException e){}
                              }
                         }).start();
     }
}
