package gui;
import java.awt.event.*;
import javax.swing.*;
public class Events implements ActionListener{
     JButton b;
     public void actionPerformed(ActionEvent e) {
          b=(JButton)e.getSource();
          
          System.out.println(" csscscsccscc" + e);
     }

          
}
