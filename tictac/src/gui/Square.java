package gui;
import java.awt.*;
import javax.swing.*;
import game.*;
class Square extends JButton{
     public final int index;
     public static final Icon x=new ImageIcon("resource\\cross.png"),
          o=new ImageIcon("resource\\circle.png"),
          xw=new ImageIcon("resource\\crossw.png"),
          ow=new ImageIcon("resource\\circlew.png"),
          n=new ImageIcon("resource\\null.png");
     Square(MultiEvents e,int index){
          super.setSize(150,150);
          setVisible(true);
          setIcon(n);
          this.index=index;
          addActionListener(e);
     }
}
