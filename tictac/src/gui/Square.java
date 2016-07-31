package gui;
import java.awt.*;
import javax.swing.*;
import game.*;
class Square extends JButton{
     public static final Icon x=new ImageIcon("src\\cross.png"),
          o=new ImageIcon("src\\circle.png"),
          xw=new ImageIcon("src\\crossw.png"),
          ow=new ImageIcon("src\\circlew.png"),
          n=new ImageIcon("src\\null.png");
     Square(Events e){
          super.setSize(150,150);
          setVisible(true);
          setIcon(n);
          addActionListener(e);
     }
     void changesym(eboard e){
          
          
     }
}
