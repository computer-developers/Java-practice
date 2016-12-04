package lib.modules.player;
public class InvalidSymbolException extends RuntimeException{
     public String toString(){
          return "Symbol is not allowed..";
     }
}