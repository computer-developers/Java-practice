package gui;
import java.awt.*;
import game.*;
import player.*;
import ai.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
class GuiBoard extends JFrame{
     GameData gd;
     Player px,po;
     SingleEvents e;
     Square g[]=new Square[9];
     GuiBoard(String px,String po){
          try {
               gd=new GameData();
               this.px=new Player(px,gd,eboard._X);
               this.po=new Player(po,gd,eboard._O);
               e=new SingleEvents(gd,this.px,this.po,this);
               Ai ai=new Ai(eboard._O);
               for(int i=0;i<9;i++){
                    g[i]=new Square(e,i);
                    add(g[i]);
               }
               setLayout(new GridLayout(3,3));
               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          } catch(InvalidSymbolException ex) { }
     }
     GuiBoard(){
          this("PlayerX","PlayerO");
     }
     void win(String s,eboard e){
          int d=Integer.parseInt(s);
          if(e==eboard._O){
               for(int i=0;i<=2;i++){
                    int c=d%10;
                    //if(c>=0&&c<=8)
                    g[c].setIcon(Square.ow);
                    d=d/10;
               }
               JOptionPane.showMessageDialog(this,po+" wins","Result",INFORMATION_MESSAGE);
          }
          else{
               for(int i=0;i<=2;i++){
                    int c=d%10;
                    //if(c>=0&&c<=8)
                    g[c].setIcon(Square.xw);
                    d=d/10;
               }
               JOptionPane.showMessageDialog(this,px+" wins","Result",INFORMATION_MESSAGE);
          }
     }
}