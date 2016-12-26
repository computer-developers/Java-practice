package lib.modules.message;
import lib.modules.player.IntPlayer;
import lib.modules.gameboard.*;
import lib.modules.player.SimplePlayer;
public class ClientMessage {
     public static final String Move="move";
     public static final String Details="details";
     public static final String CC="@";
     public static final String makeMove(eboard e,int x){
          return e.name()+CC+x;
     }
     public static final String makeDetail(IntPlayer p){
          return p.getName()+CC+p.getSym();
     }
     public static final IntPlayer getDetail(String s){
          String arr[]=s.split(CC,3);
          if(arr[0]==null||arr[0].equals("null"))
               return null;
          if(arr[1]==null||arr[1].equals("null"))
               return null;
          return SimplePlayer.getSP(arr[0],null,eboard.valueOf(arr[1]));
     }
     
}
