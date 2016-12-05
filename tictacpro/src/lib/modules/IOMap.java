package lib.modules;
import lib.myio.*;
import lib.modules.player.*;
import lib.modules.gameboard.*;
import static lib.modules.gameboard.eboard.*;
public class IOMap {
     private int l;
     private IntPlayer pl[];
     private IOManager io[];
     public IOMap(int x){
          if(x<2)
               return;
          l=x;
          io=new IOManager[x];
          pl=new IntPlayer[x];
     }
     public synchronized boolean add(IOManager i,IntPlayer p){
          if(p.getSym()==_N)return false;
          r:{
               for(int j=0;j<l;j++){
                    try{
                         if(pl[j].getSym()==p.getSym())
                              return false;
                    }catch(NullPointerException ex){}
               }
          }
          for(int j=0;j<l;j++){
               if(pl[j]==null){
                    pl[j]=p;
                    io[j]=i;
                    return true;
               }
          }
          return false;
     }
     public synchronized boolean remove(IntPlayer p){
          for(int j=0;j<l;j++){
               try{
                    if(pl[j].equals(p)){
                         pl[j]=null;
                         io[j]=null;
                         return true;
                    }
               }catch(NullPointerException ex){}
          }
          return false;
     }
     public IOManager getIO(IntPlayer p){
          for(int j=0;j<l;j++){
               try{
                    if(pl[j].getSym()==p.getSym())
                         return io[j];
               }catch(NullPointerException ex){}
          }
          return null;
     }
     public IntPlayer getPlayer(IOManager i){
          for(int j=0;j<l;j++){
               try{
                    if(io[j]==i)
                         return pl[j];
               }catch(NullPointerException ex){}
          }
          return null;
     }
     public IOManager getIO(eboard e){
          for(int j=0;j<l;j++){
               try{
                    if(pl[j].getSym()==e)
                         return io[j];
               }catch(NullPointerException ex){}
          }
          return null;
     }
     public IntPlayer[] getAllPlayer(){
          return pl.clone();
     }
}
