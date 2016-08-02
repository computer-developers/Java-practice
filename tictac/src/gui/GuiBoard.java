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
     MultiEvents e;
     Square g[]=new Square[9];
     private void init(GameData gd,MultiEvents e){
          try {
               this.gd=gd;
               this.e=e;
               for(int i=0;i<9;i++){
                    g[i]=new Square(e,i);
                    add(g[i]);
               }
               setLayout(new GridLayout(3,3));
               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          } catch(InvalidSymbolException ex) { }
     }
     GuiBoard(String px,String po){
          GameData gd=new GameData();
          this.px=new Player(px,gd,eboard._X);
          this.po=new Player(po,gd,eboard._O);
          init(new GameData(),new MultiEvents(gd,this.px,this.po,this));
     }
     GuiBoard(String p,eboard eb){
          if(eb.c=='X'){
               GameData g=new GameData();
               px=new Player(p,g,eb);
               init(g,new SingleEvents(g,this,px,eb));
          }else if(eb.c=='O'){
               GameData g=new GameData();
               po=new Player(p,g,eb);
               init(g,new SingleEvents(g,this,po,eb));
          }
          else
          throw new InvalidSymbolException();
     }
     GuiBoard(){
          this("playerx","playero");
     }
     void win(String s,eboard e){
          int d=Integer.parseInt(s);
          if(e==eboard._O){
               for(int i=0;i<=2;i++){
                    int c=d%10;
                    g[c].setIcon(Square.ow);
                    d=d/10;
               }
               JOptionPane.showMessageDialog(this,po+" wins","Result",INFORMATION_MESSAGE);
          }
          else{
               for(int i=0;i<=2;i++){
                    int c=d%10;
                    g[c].setIcon(Square.xw);
                    d=d/10;
               }
               JOptionPane.showMessageDialog(this,px+" wins","Result",INFORMATION_MESSAGE);
          }
          this.e.f=false;
     }
}