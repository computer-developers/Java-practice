package game;
public enum eboard{
     _X(1,'X'),_O(0,'O'),_N(-1,'N');
     public final int v;
     public final char c;
     eboard(int a,char b){
          v=a;
          c=b;
     }
}