package lib.modules.message;
import lib.modules.gameboard.*;
public class ClientMessage {
     public static final String Move="move";
     public static final String CC="@";
     public static final String makeMove(eboard e,int x){
          return e.name()+CC+x;
     }
}
