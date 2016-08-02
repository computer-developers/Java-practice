package game;
public enum eboard{
     _N(-1,'N'),_O(0,'O'),_X(1,'X');
     public final int v;
     public final char c;
     eboard(int a,char b){
          v=a;
          c=b;
     }
     public eboard oppo(){
          if(this==_X)
               return _O;
          else if(this==_O)
               return _X;
          return this;
     }
     public static eboard[] getAll(){
          eboard[] e={_O,_X};
          return e;
     }
}