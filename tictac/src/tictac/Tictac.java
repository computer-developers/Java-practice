package tictac;
import game.*;
import ai.*;
import player.*;
import java.util.Random;
public class Tictac {
     public static void main(String[] args) {
          try{
          GameData g=new GameData();
          Ai a=new Ai(g,eboard._O);
          Player p=new Player("neel",g,eboard._X);
          Random r=new Random();
          p.move(r.nextInt(8));
          a.move();
          p.move(r.nextInt(8));
          a.move();
          p.move(r.nextInt(8));
          a.move();
          p.move(r.nextInt(8));
          a.move();
          }catch(Exception e){System.out.println("fsfksfk");}
     }
}
