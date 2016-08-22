import java.io.*;
import java.util.*;
class InputGen{
	static Scanner sc=new Scanner(System.in);
	public static void main(String arg[]){
		System.out.println("enter number of elements..");
		int l=sc.nextInt();
		setOut();
		Random rn=new Random();
		for(int i=0;i<l;i++)
			System.out.println(rn.nextInt());
	}
	static void setOut(){
		try{
			PrintStream p=new PrintStream("input.txt");
			System.setOut(p);
		}catch(FileNotFoundException ex){}
	}
}