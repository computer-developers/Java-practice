package lib.modules.gui;
import javax.swing.*;
import java.util.function.*;
import java.awt.event.*;
import static lib.modules.gameboard.eboard.*;
import static lib.modules.gui.Square.*;
import lib.modules.gameboard.*;
public class GuiBoard3 extends JPanel {
     Square g[]=new Square[9];
     Consumer<? super Integer>cs=(i)->{};
     public GuiBoard3(){
          initComponents();
          for(int i=0;i<9;i++){
                    g[i]=new Square(ev->guiMove(ev),i);
                    add(g[i]);
               }
     }
     public void update(int i,eboard e){
          switch (e){
               case _X:g[i].update(X);break;
               case _O:g[i].update(O);break;
          }
     }
     public void win(eboard e,int... ar){
          switch (e){
               case _X:
                    for(int i:ar)g[i].update(XW);break;
               case _O:
                    for(int i:ar)g[i].update(OW);break;
          }
     }
     void guiMove(ActionEvent ev){
          Square s=(Square)ev.getSource();
          cs.accept(s.index);
     }
     public void setConsumer(Consumer<? super Integer>cs){
          this.cs=cs;
     }
     
     
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          setBackground(new java.awt.Color(0, 0, 0));
          setForeground(new java.awt.Color(255, 255, 255));
          setAlignmentX(0.0F);
          setAlignmentY(0.0F);
          setMaximumSize(new java.awt.Dimension(450, 450));
          setMinimumSize(new java.awt.Dimension(450, 450));
          setPreferredSize(new java.awt.Dimension(450, 450));

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 450, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 450, Short.MAX_VALUE)
          );
     }// </editor-fold>//GEN-END:initComponents


     // Variables declaration - do not modify//GEN-BEGIN:variables
     // End of variables declaration//GEN-END:variables
}
