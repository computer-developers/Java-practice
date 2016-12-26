package lib.modules.gui;
import lib.modules.gameboard.*;
import lib.modules.IOMap;
import lib.modules.player.*;
import lib.modules.gameboard.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lib.modules.message.ClientMessage;
//import static lib.modules.message.ClientMessage.*;
import static lib.modules.message.ServerMessage.*;
public class GuiSinglePlayer3 extends JFrame{
     GuiBoard3 board;
     IOMap iomap;
     GuiControl2 gc;
     final static String s[]={"Play With Artificial Intelligence","Play with another Player"};
     public GuiSinglePlayer3(IntPlayer i){
          iomap=new IOMap();
          iomap.createInPipe(200);
          iomap.setConsumer(s->func(iomap,s));
          iomap.addPlayer(i);
          gc=new GuiControl2(i.getSym()==eboard._X?i.getName():"Player",
                    i.getSym()==eboard._O?i.getName():"Player");
          board=new GuiBoard3();
          board.setConsumer(this::move);
     }
     
     public void func(IOMap pl,String s){
         // System.out.println("ser func :- "+s);
          String arr[]=s.split(" ",2);
          switch(arr[0]){
               case Board_Update:
                    for(int i=0;i<9;i++){
                         board.update(i,pl.getSym());
                    }
                    break;
               case Board_Status:
                    if(arr[1].split(SC,3)[0].equals(BS_Win)){
                         for(String t:arr[1].split("_",3))
                              board.win(eboard._N,Integer.parseInt(t));
                    }
                    break;
          }
     }
     
     void move(int ind){
          iomap.putMessage(ClientMessage.makeMove(iomap.getSym(),ind));
     }
     
     void boardinit(){
          add(board);
          setVisible(true);
          setSize(699,479);
          setTitle("Tic Tac Toe");
          //super.setIconImage(new Image("src\\circlew.png"));
          setLocation(100,50);
          super.setResizable(false);
          setlay();
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