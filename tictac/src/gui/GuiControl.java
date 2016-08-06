package gui;
import javax.swing.*;
import game.*;
import player.*;
public class GuiControl extends javax.swing.JPanel {
     Gui g;
     int iwx=0,iwo=0;
     GuiControl(String px,String po,Gui g){
          initComponents();
          nx.setText(px);
          no.setText(po);
          this.g=g;
     }
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          nx = new javax.swing.JLabel();
          sx = new javax.swing.JLabel();
          wx = new javax.swing.JLabel();
          jPanel2 = new javax.swing.JPanel();
          no = new javax.swing.JLabel();
          so = new javax.swing.JLabel();
          wo = new javax.swing.JLabel();
          newgame = new javax.swing.JButton();

          setBackground(new java.awt.Color(0, 0, 0));
          setMaximumSize(new java.awt.Dimension(200, 450));
          setMinimumSize(new java.awt.Dimension(200, 450));
          setName("GuiC"); // NOI18N
          setPreferredSize(new java.awt.Dimension(200, 450));
          setVerifyInputWhenFocusTarget(false);

          jPanel1.setBackground(new java.awt.Color(0, 0, 0));
          jPanel1.setName("bx"); // NOI18N

          nx.setBackground(new java.awt.Color(0, 0, 0));
          nx.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
          nx.setForeground(new java.awt.Color(0, 255, 204));
          nx.setText("PlayerX");
          nx.setName("nx"); // NOI18N

          sx.setBackground(new java.awt.Color(0, 0, 0));
          sx.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          sx.setForeground(new java.awt.Color(255, 255, 255));
          sx.setText("Symbol : X");
          sx.setName("sx"); // NOI18N

          wx.setBackground(new java.awt.Color(0, 0, 0));
          wx.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          wx.setForeground(new java.awt.Color(255, 255, 255));
          wx.setText("Match Won : 0");
          wx.setName("wx"); // NOI18N

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(nx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(sx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(wx, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(nx, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sx, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(wx, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE))
          );

          jPanel2.setBackground(new java.awt.Color(0, 0, 0));

          no.setBackground(new java.awt.Color(0, 0, 0));
          no.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
          no.setForeground(new java.awt.Color(0, 255, 204));
          no.setText("PlayerO");
          no.setName("no"); // NOI18N

          so.setBackground(new java.awt.Color(0, 0, 0));
          so.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          so.setForeground(new java.awt.Color(255, 255, 255));
          so.setText("Symbol : O");
          so.setName("so"); // NOI18N

          wo.setBackground(new java.awt.Color(0, 0, 0));
          wo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          wo.setForeground(new java.awt.Color(255, 255, 255));
          wo.setText("Match Won : 0");
          wo.setName("wo"); // NOI18N

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(so, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(wo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addContainerGap())
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(so, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(wo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE))
          );

          newgame.setBackground(new java.awt.Color(0, 0, 0));
          newgame.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          newgame.setForeground(new java.awt.Color(255, 255, 51));
          newgame.setText("New Game");
          newgame.setToolTipText("");
          newgame.setName("newgame"); // NOI18N
          newgame.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    newgameActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(newgame)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE))
          );
     }// </editor-fold>//GEN-END:initComponents

     private void newgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newgameActionPerformed
          g.notify(true);
     }//GEN-LAST:event_newgameActionPerformed


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JButton newgame;
     private javax.swing.JLabel no;
     private javax.swing.JLabel nx;
     private javax.swing.JLabel so;
     private javax.swing.JLabel sx;
     private javax.swing.JLabel wo;
     private javax.swing.JLabel wx;
     // End of variables declaration//GEN-END:variables
     private String getw(int i){
          String s=new String("Match Won : "+Integer.toString(i));
          return s;
     }
     void notify(eboard e){
          if(e.c=='X')
               wx.setText(getw(++iwx));
          else if(e.c=='O')
               wo.setText(getw(++iwo));
          else
               throw new InvalidSymbolException();
     }
}
