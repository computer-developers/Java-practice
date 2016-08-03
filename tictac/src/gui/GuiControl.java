package gui;
import java.awt.*;
import javax.swing.*;
public class GuiControl extends JPanel{
     JButton newgame=new JButton("New Game"),
               cx=new JButton("Change name"),co=new JButton("Change name");
     JLabel tx,to,wx,wo;
     int winx,wino;
     final JLabel sx=new JLabel("Symbol : X"),so=new JLabel("Symbol : O");
     JPanel comx=new JPanel(),como=new JPanel();
     public GuiControl(String px,String po){
          X:{
               tx=new JLabel(px);
               wx=new JLabel(getw(0));
               comx.add(tx);
               comx.add(sx);
               comx.add(wx);
               comx.add(cx);
               tx.setBounds(10,10,10,100);
               sx.setBounds(10,20,10,100);
               wx.setBounds(10,30,10,100);
               cx.setBounds(10,40,10,100);
               comx.setVisible(true);
          }
          O:{
               to=new JLabel(po);
               wo=new JLabel(getw(0));
               como.add(to);
               como.add(so);
               como.add(wo);
               como.add(co);
               to.setLocation(10,10);
               so.setLocation(20,10);
               wo.setLocation(30,10);
               co.setLocation(40,10);
               como.setSize(80,60);
               como.setVisible(true);
          }
          add(comx);
          comx.setBounds(10,10,100,110);
          add(como);
          como.setBounds(10,110,100,110);
          setSize(450,100);
          setVisible(true);
     }
     private String getw(int i){
          String s=new String("match won : "+Integer.toString(i));
          return s;
     }
}