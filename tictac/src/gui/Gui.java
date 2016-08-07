package gui;
import game.*;
import player.InvalidSymbolException;
import java.awt.*;
import javax.swing.*;
public class Gui extends JFrame{
     GuiBoard board;
     String p,px,po;
     eboard withai,e=eboard._N;
     GuiControl gc;
     final static String s[]={"Play With Artificial Intelligence","Play with another Player"};
     public Gui(){
          int i=JOptionPane.showOptionDialog(
                    null,"select one of the following","Tic Tac Toe",1,1, null,s,0);
          if(i==-1)return;
          else if(i==0){
               p=JOptionPane.showInputDialog("Enter Player's Name","player");
               int eb=JOptionPane.showOptionDialog(null,"select symbol",p,1,1,null,eboard.getAll(),0);
               if(eb==0){
                    board=new GuiBoard(p,eboard._O,this);
                    withai=eboard._X;
               }
               else if(eb==1){
                    board=new GuiBoard(p,eboard._X,this);
                    withai=eboard._O;
               }
               else return;
          }
          else if(i==1){
               px=JOptionPane.showInputDialog("Enter X's Player Name","playerX");
               po=JOptionPane.showInputDialog("Enter O's Player Name","playerO");
               board=new GuiBoard(px,po,this);
               withai=eboard._N;
          }
          px=board.px.name;
          po=board.po.name;
          gc=new GuiControl(px,po,this);
          boardinit();
     }
     void boardinit()
     {
          add(board);
          setVisible(true);
          setSize(699,479);
          setTitle("Tic Tac Toe");
          //super.setIconImage(new Image("src\\circlew.png"));
          setLocation(100,50);
          super.setResizable(false);
          setlay();
     }
     public void notify(boolean b){
          if(b){
               remove(board);
               if(withai==eboard._N){
                    board=new GuiBoard(px,po,this);
               }
               else{
                    board=new GuiBoard(p,withai.oppo(),this); 
               }
               boardinit();
          }
     }
     public void notify(eboard e){
          try{
               if(e!=eboard._N)this.e=e;
               else if(this.e!=eboard._N)
                    this.e=this.e.oppo();
               else
                    this.e=eboard._X;
               gc.notify(e);
          }catch(InvalidSymbolException ex){}
     }
     void setlay(){
          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          board.setMaximumSize(new java.awt.Dimension(450, 450));
          board.setMinimumSize(new java.awt.Dimension(450, 450));
          board.setPreferredSize(new Dimension(450,450));

          gc.setMaximumSize(new java.awt.Dimension(240, 450));
          gc.setMinimumSize(new java.awt.Dimension(240, 450));
          gc.setPreferredSize(new java.awt.Dimension(240, 450));

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(board, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(gc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          board.setVisible(true);
          gc.setVisible(true);
     }
}