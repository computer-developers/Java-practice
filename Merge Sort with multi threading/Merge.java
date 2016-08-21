import java.util.*;
public class Merge{
	static Scanner sc=new Scanner(System.in);
	public static void main(String arg[]){
		proc(20);
	}
	static void proc(int a){
		try{
			ArrayList<Integer> arr=new ArrayList<>(a);
			for(int i=0;i<a;i++)
				arr.add(sc.nextInt());
			MSort m=new MSort(arr);
			Thread t=new Thread(m);
			t.run();
			t.join();
			for(int i=0;i<arr.size();i++)
				System.out.println(arr.get(i));
		}catch(InterruptedException ex){System.out.println("cscccscssc");}
	}
}