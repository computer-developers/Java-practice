package gui;
import ai.*;
import game.*;
import player.*;
import game.*;
public class MultiEvents extends SingleEvents{
     public MultiEvents(GameData g, GuiBoard bor, Player p,eboard e)throws InvalidSymbolException{
               super(g,new Ai(g,e.oppo()), p, bor);
          }
     }
     