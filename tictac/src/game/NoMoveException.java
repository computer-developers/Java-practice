package game;
public class NoMoveException extends RuntimeException{
     NoMoveException(){
     }
     NoMoveException(String s){
          super(s);
     }
     public String toString(){
          return getMessage();
     }
}