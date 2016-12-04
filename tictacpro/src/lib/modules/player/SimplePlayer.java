package lib.modules.player;

import lib.modules.gameboard.*;

public class SimplePlayer implements IntPlayer{
     private String name;
     private GameData board;
     private eboard sym;
     @Override
     public String getName() {
          return name;
     }

     @Override
     public eboard getSym() {
          return sym;
     }

     @Override
     public GameData getBoard() {
          return board;
     }

     @Override
     public void setSym(eboard e){
          this.sym=e;
     }

     @Override
     public boolean setName(String name) {
          this.name=name;
          return true;
     }

     @Override
     public boolean setBoard(GameData g) {
          this.board=g;
          return true;
     }
     
}
