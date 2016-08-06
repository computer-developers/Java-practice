package gui;
import ai.*;
import game.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import player.*;
public class MultiEvents implements ActionListener{
     Square b;
     boolean f=true;
     GuiBoard bor;
     GameData g;
     Player px,po;
     boolean turn=true;
     public void actionPerformed(ActionEvent e){
          if(!f)return;
          try{
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
          }catch(NoMoveException ex){}
          finally{
               check();
          }
     }
     void check(){
          try{
          if(!f||g.check()==eboard._N)
               return;
          String s=g.getWin();
          bor.win(s,g.check());
          }catch(NoMoveException e){
               f=false;
               System.out.println(f);
               JOptionPane.showMessageDialog(bor,e,"",INFORMATION_MESSAGE);
          }
     }
     public MultiEvents(GameData g,Player px,Player po,GuiBoard bor){
          this.g=g;
          this.bor=bor;
          if(px.e==eboard._X&&po.e==eboard._O){
               this.px=px;
               this.po=po;
          }
          else if(px.e==eboard._O&&po.e==eboard._X){
               this.px=po;
               this.po=px;
               bor.po=px;
               bor.px=po;
          }
          else
               throw new InvalidSymbolException();
     }
          
}
