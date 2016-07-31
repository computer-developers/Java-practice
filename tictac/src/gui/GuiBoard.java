package gui;
import java.awt.*;
import game.*;
import player.*;
import ai.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
class GuiBoard extends JFrame{
     GameData gd=new GameData();
     Events e=new Events();
     Square g[]=new Square[9];
     GuiBoard(){
          try {
               Player ply=new Player("player",gd,eboard._X);
               Ai ai=new Ai(eboard._O);
               for(Square f:g){
                    f=new Square(e);
                    add(f);
               }
               setLayout(new GridLayout(3,3));
               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          } catch(InvalidSymbolException ex) { }
     }
}