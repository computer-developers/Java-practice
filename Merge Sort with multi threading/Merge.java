import java.util.*;
import java.io.*;
public class Merge{
	static Scanner sc;
	public static void main(String arg[]){
		prof("input.txt","outputM.txt");
		sc=new Scanner(System.in);
		procm();
		prof("input.txt","outputI.txt");
		sc=new Scanner(System.in);
		proci();
	}
	static void procm(){
		try{
			ArrayList<Integer> arr=new ArrayList<>();
			try{
				for(;true;)
					arr.add(sc.nextInt());
			}catch(NoSuchElementException ex){}
			MSort m=new MSort(arr);
			Thread t=new Thread(m);
			long st=System.nanoTime();
			t.run();
			System.out.println("Time in nano second: "+(System.nanoTime()-st));
			for(int i=0;i<arr.size();i++)
				System.out.println(arr.get(i));
		}catch(Exception ex){System.out.println(ex);}
	}
	static void proci(){
		try{
			ArrayList<Integer> arr=new ArrayList<>();
			try{
				for(;true;)
					arr.add(sc.nextInt());
			}catch(NoSuchElementException ex){}
			long st=System.nanoTime();
			arr=MSort.insertS(arr);
			System.out.println("Time in nano second: "+(System.nanoTime()-st));
			for(int i=0;i<arr.size();i++)
				System.out.println(arr.get(i));
		}catch(Exception ex){System.out.println(ex);}
	}
	static void prof(String ins,String outs){
		try{
			FileInputStream in = new FileInputStream(ins);
			PrintStream out = new PrintStream(outs);
			System.setIn(in);
			System.setOut(out);
		}catch(FileNotFoundException ex){System.out.println(ex);}
	}
}