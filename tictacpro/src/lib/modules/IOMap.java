package lib.modules;
import lib.myio.*;
import lib.modules.player.*;
import lib.modules.gameboard.*;
import static lib.modules.gameboard.eboard.*;
public class IOMap extends IOManager implements IntPlayer{
//     private int l;
     private IntPlayer pl;
     public IOMap(){}
     public IOMap(String name){
          super(name);
     }
     public synchronized void addPlayer(IntPlayer p){
//          if(p.getSym()==_N)return false;
          pl=p;
     }
     public synchronized void remove(){
          pl=null;
     }
     
     @Override
     public String getName() {
          if(pl==null)
               return null;
          return pl.getName();
     }

     @Override
     public eboard getSym() {
          if(pl==null)
               return null;
          return pl.getSym();
     }

     @Override
     public GameData getBoard() {
          if(pl==null)
               return null;
          return pl.getBoard();
     }

     @Override
     public IntPlayer setSym(eboard e) throws InvalidSymbolException {
          if(pl==null)
               return null;
          return pl=pl.setSym(e);
     }

     @Override
     public IntPlayer setName(String name) {
     if(pl==null)
               return null;
          return pl=pl.setName(name);
     }

     @Override
     public IntPlayer setBoard(GameData g) {
     if(pl==null)
               return null;
          return pl=pl.setBoard(g);}
     }
