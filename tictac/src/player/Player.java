package player;
import game.*;
public class Player{
     public final String name;
     public final eboard e;
     public final GameData board;
     public int w=0;
     public Player(String name,GameData g,eboard e) throws InvalidSymbolException{
          this.name=name;
          if(e.c=='N')throw new InvalidSymbolException();
          this.e=e;
          board=g;
          board.setplayer(this);
     }
     public Player changeName(String s) throws InvalidSymbolException{
          Player x=new Player(s,board,e);
          x.w=this.w;
          return x;
     }
     public Player changeGame(GameData g) throws InvalidSymbolException{
          Player x=new Player(name,g,this.e);
          x.w=this.w;
          return x;
     }
     public Player changeSymbol(eboard e) throws InvalidSymbolException{
          Player x=new Player(name,board,e);
          x.w=this.w;
          return x;
     }
     public boolean move(int x,int y){
          return board.upDate(GameData.getind(x, y), e);
     }
     public boolean move(int x){
          return board.upDate(x,e);
     }
     public void upDate(int x,eboard e){}
     public String toString(){
          return name;
     }
}