package rmiob;

import java.io.Serializable;

/**
 *
 * @author Neel Patel
 */
public class MyClass implements Serializable{
     public void printPath(){
          System.out.println("Paths :- "+System.getProperty("user.dir"));
     }
}
