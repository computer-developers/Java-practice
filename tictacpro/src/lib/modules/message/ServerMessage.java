package lib.modules.message;
import lib.modules.gameboard.*;
public class ServerMessage {
     public static final String SC="@";
     public static final String Board_Update="board_update";
     public static final String Board_Status="board_Status";
     public static final String BS_Win="win";
     public static final String BS_Draw="draw";
     public static final String BS_Run="running";
     public static final String Board_Detail="board_detail";
     public static final String Board_Error="board_error";
     public static final String BE_Sym="Invalid_symbol";
     public static final String makeBS_win(eboard e,String s){
          return BS_Win+SC+e.name()+SC+s;
     }
     public static final String makeBS_Run(eboard turn){
          return BS_Run+SC+turn.name();
     }
}
