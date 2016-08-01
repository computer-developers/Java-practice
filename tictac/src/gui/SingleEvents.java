package gui;
import ai.*;
import game.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import player.*;
public class SingleEvents implements ActionListener{
     Square b;
     GuiBoard bor;
     GameData g;
     Player px,po;
     boolean turn=true;
     public void actionPerformed(ActionEvent e){
          b=(Square)e.getSource();
          if(turn){
              if(!px.move(b.index))
                  return;
              b.setIcon(Square.x);
              turn=false;
          }
          else{
              if(!po.move(b.index))
                  return;
              b.setIcon(Square.o);
              turn=true;
          }
          check();
          //System.out.println(" csscscsccscc" + e);
     }
     void check(){
          try{
          if(g.check()==eboard._N)
               return;
          String s=g.getWin();
          System.out.println("string s="+s);
          bor.win(s,g.check());
          }catch(NoMoveException e){
               JOptionPane.showMessageDialog(bor,e.getMessage(),"",INFORMATION_MESSAGE);
          }
     }
     public SingleEvents(GameData g,Player px,Player po,GuiBoard bor){
         this.g=g;
         this.px=px;
         this.po=po;
         this.bor=bor;
     }
          
}
