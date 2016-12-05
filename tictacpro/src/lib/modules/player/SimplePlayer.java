package lib.modules.player;

import lib.modules.gameboard.*;

public class SimplePlayer implements IntPlayer{
     private String name;
     private GameData board;
     private eboard sym;
     private SimplePlayer(String name){
          this.name=name;
     }
     public static IntPlayer getSP(String name){
          return new SimplePlayer(name);
     }
     public static IntPlayer getSP(String name,GameData g,eboard e){
          SimplePlayer s=new SimplePlayer(name);
          s.board=g;
          s.sym=e;
          return s;
     }
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
     public IntPlayer setSym(eboard e){
          return getSP(this.name,this.board,e);
     }

     @Override
     public IntPlayer setBoard(GameData e){
          return getSP(this.name,e,this.sym);
     }

     @Override
     public IntPlayer setName(String e){
          return getSP(e,this.board,this.sym);
     }
     
}
