package lib.modules.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.function.*;
class Square extends JButton{
     public final int index;
     public static final Icon X=new ImageIcon("resource\\cross.png"),
          O=new ImageIcon("resource\\circle.png"),
          XW=new ImageIcon("resource\\crossw.png"),
          OW=new ImageIcon("resource\\circlew.png"),
          N=new ImageIcon("resource\\null.png");
     Square(ActionListener al,int index){
          super.setSize(150,150);
          setVisible(true);
          setIcon(N);
          this.index=index;
          addActionListener(al);
     }
     public void update(Icon i){
          this.setIcon(i);
     }
}
