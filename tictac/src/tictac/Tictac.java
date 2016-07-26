package tictac;
import game.*;
import ai.*;
import java.util.Random;
public class Tictac {
     public static void main(String[] args) {
          GameData g=new GameData();
          Ai a=new Ai(g,eboard._O);
          Random r=new Random();
          g.upDate(r.nextInt(8), eboard._X);
          a.move();
          g.display();
          g.upDate(r.nextInt(8), eboard._X);
          a.move();
          g.display();
          g.upDate(r.nextInt(8), eboard._X); 
          a.move();
          g.display();
     }
}
