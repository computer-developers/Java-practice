package player;
public class InvalidSymbolException extends RuntimeException{
     public String toString(){
          return "Symbol _N is not allowed..";
     }
}