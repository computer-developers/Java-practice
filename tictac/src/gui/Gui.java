package gui;
import game.eboard;
import java.awt.*;
import javax.swing.JOptionPane;
public class Gui{
     GuiBoard board;
     final static String s[]={"Play With Artificial Intelligence","Play with another Player"};
     public Gui(){
          int i=JOptionPane.showOptionDialog(
                    null,"select one of the following","Tic Tac Toe",1,1, null,s,0);
          if(i==-1)return;
          else if(i==0){
               String p=JOptionPane.showInputDialog("Enter Player's Name","player");
               int eb=JOptionPane.showOptionDialog(null,"select symbol",p,1,1,null,eboard.getAll(),0);
               if(eb==0)board=new GuiBoard(p,eboard._O);
               else if(eb==1)board=new GuiBoard(p,eboard._X);
               else return;
          }
          else if(i==1){
               String px=JOptionPane.showInputDialog("Enter X's Player Name","playerX");
               String po=JOptionPane.showInputDialog("Enter O's Player Name","playerO");
               board=new GuiBoard(px,po);
          }
          board.setSize(450,450);
          board.setResizable(false);
          board.setVisible(true);
     }
}