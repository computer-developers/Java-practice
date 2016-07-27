package interfaces;
public interface IntDataStructure{
     default boolean add(int x){
          System.out.println("method not define!!!");
          return false;
     }
     default int delete(){
          System.out.println("method not define!!!");
          throw new ArithmeticException(); 
     }
}