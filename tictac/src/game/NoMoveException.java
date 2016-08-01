package game;
public class NoMoveException extends Exception{
     NoMoveException(){
     }
     NoMoveException(String s){
          super(s);
     }
}