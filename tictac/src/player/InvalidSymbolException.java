package player;
public class InvalidSymbolException extends Exception{
     public String toString(){
          return "Symbol _N is not allowed..";
     }
}