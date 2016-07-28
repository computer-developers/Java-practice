package tictac;
import game.*;
import ai.*;
import player.*;
import java.util.Random;
import java.util.Scanner;
public class Tictac {
     public static void main(String[] args) {
          try{
          boolean b=true;
          Scanner sc=new Scanner(System.in);
          GameData g=new GameData();
          Ai a=new Ai(g,eboard._O);
          Player p=new Player("neel",g,eboard._X);
          for(;g.check()==eboard._N;){
               if(b)     
                    p.move(sc.nextInt());
               else 
                    a.move();
               System.out.println(g.display());
               b=!b;
          }
          }catch(InvalidSymbolException e){System.out.println("fsfksfk");}
     }
}
