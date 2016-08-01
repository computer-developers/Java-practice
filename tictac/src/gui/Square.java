package gui;
import java.awt.*;
import javax.swing.*;
import game.*;
class Square extends JButton{
     public final int index;
     public static final Icon x=new ImageIcon("src\\cross.png"),
          o=new ImageIcon("src\\circle.png"),
          xw=new ImageIcon("src\\crossw.png"),
          ow=new ImageIcon("src\\circlew.png"),
          n=new ImageIcon("src\\null.png");
     Square(SingleEvents e,int index){
          super.setSize(150,150);
          setVisible(true);
          setIcon(n);
          this.index=index;
          addActionListener(e);
     }
     void changesym(eboard e){
          
          
     }
}
