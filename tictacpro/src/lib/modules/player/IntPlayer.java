package lib.modules.player;
import lib.modules.gameboard.*;
public interface IntPlayer {
     String getName();
     eboard getSym();
     GameData getBoard();
     void setSym(eboard e)throws InvalidSymbolException;
     boolean setName(String name);
     boolean setBoard(GameData g);
}
