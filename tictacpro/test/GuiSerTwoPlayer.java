import lib.modules.gui.*;
import lib.modules.player.*;
import lib.modules.gameboard.*;
import client.guiplayer.*;
import server.*;
public class GuiSerTwoPlayer {
     public static void main(String... arg){
          SerTwoPlayer ser=new SerTwoPlayer();
          SingleGui3 p1=new SingleGui3(), p2=new SingleGui3();
          p1.setInPutPipe(()->ser.setPlayer(p1, SimplePlayer.getSP("default", null, eboard._N)));
          p2.setInPutPipe(()->ser.setPlayer(p2, SimplePlayer.getSP("default", null, eboard._N)));
     }
}
