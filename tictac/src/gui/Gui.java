package gui;
import java.awt.*;
import javax.swing.*;
public class Gui{
     GuiBoard board;
     public Gui(){
          board=new GuiBoard();
          board.setSize(450,450);
          board.setResizable(false);
          board.setVisible(true);
     }
}