package lib.modules.player;
import lib.modules.gameboard.*;
public interface IntPlayer {
     String getName();
     eboard getSym();
     GameData getBoard();
     IntPlayer setSym(eboard e)throws InvalidSymbolException;
     IntPlayer setName(String name);
     IntPlayer setBoard(GameData g);
}
