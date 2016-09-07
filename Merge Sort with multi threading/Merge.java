import java.util.*;
import java.io.*;
public class Merge{
	static Scanner sc;
	public static void main(String arg[]){
		prof("input.txt","outputM.txt");
		sc=new Scanner(System.in);
		procm();
		prof("input.txt","outputS.txt");
		sc=new Scanner(System.in);
		procs();
/*		prof("input.txt","outputPS.txt");
		sc=new Scanner(System.in);
		procps();*/
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
//			Thread t=new Thread(m);
			long st=System.nanoTime();
			m.run();
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
	static void procs(){
		try{
			ArrayList<Integer> arr=new ArrayList<>();
			try{
				for(;true;)
					arr.add(sc.nextInt());
			}catch(NoSuchElementException ex){}
			Object air[]=arr.toArray();
			long st=System.nanoTime();
			Arrays.sort(air);
			System.out.println("Time in nano second: "+(System.nanoTime()-st));
			arr=new ArrayList(Arrays.asList(air));
			for(int i=0;i<arr.size();i++)
				System.out.println(arr.get(i));
		}catch(Exception ex){System.out.println(ex);}
	}
	static void procps(){
		try{
			int arr[]=new int[5000];
			try{
				for(int i=0;i<1000;i++)
					arr[i]=sc.nextInt();
			}catch(NoSuchElementException ex){}
			long st=System.nanoTime();
			Arrays.parallelSort(arr);
			System.out.println("Time in nano second: "+(System.nanoTime()-st));
			for(int i=0;i<arr.length;i++)
				System.out.println(arr[i]);
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