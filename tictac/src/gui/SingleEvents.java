package gui;
import ai.*;
import game.*;
import game.*;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import player.*;
public class SingleEvents extends MultiEvents{
     private Ai ai;
     Icon iai;
     private boolean turns;
     public SingleEvents(GameData g, GuiBoard bor, Player p,eboard e){
          super(g,new Ai(g,e.oppo()), p, bor);
          if(e==eboard._O)
               try{
                    turns=false;
                    ai=(Ai)px;
                    bor.px=px;
                    iai=Square.x;
               }catch(IncompatibleClassChangeError ex){System.out.println(ex);}
          else
               try{
                    turns=true;
                    iai=Square.o;
                    ai=(Ai)po;
                    bor.po=po;
               }catch(IncompatibleClassChangeError ex){System.out.println(ex);}
          turn=turns;
     }
     public void actionPerformed(ActionEvent e){
          try{
               if(!f)return;
               super.actionPerformed(e);
               if(!f)return;
               if(turn!=turns){
                    int i=ai.move();
                    bor.g[i].setIcon(iai);
               }
               turn=turns;
          }catch(NoMoveException ex){}
          finally{
               check();
          }
     }
}
     