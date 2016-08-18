import java.util.*;
public class MSort implements Runnable{
	static ArrayList insertS(List<Integer>arg){
		LinkedList ls=new LinkedList();
		for(int a:arg){
			int b;
			for(b=0;b<ls.size()&&a>(int)ls.get(b);b++);
			ls.add(b,a);
		}
		return new ArrayList(ls);
	}
	ArrayList arr;
	//final int pri;
	MSort(ArrayList<Integer>arr){
		this.arr=arr;
		//this.pri=pri;
	}
	public void run(){
		try{	
			if(arr.size()<10)
				arr=insertS(arr);
			else
				merge();
		}catch(InterruptedException ex){}
	}
	void merge()throws InterruptedException{
		int x=arr.size()/2;
		MSort m1=new MSort(new ArrayList(arr.subList(0,x)));
		MSort m2=new MSort(new ArrayList(arr.subList(x+1,arr.size()-1)));
		Thread t1=new Thread(m1),t2=new Thread(m2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		arr.clear();
		int i,j,k;
		for(i=j=k=0;i<arr.size()&&(j<(int)m1.arr.size()||k<(int)m2.arr.size());i++){
			if((k==(int)m2.arr.size()&&j!=(int)m1.arr.size())||(int)m1.arr.get(j)<(int)m2.arr.get(k)){
				arr.add(m1.arr.get(j));
				j++;
			}
			else{
				arr.add(m2.arr.get(k));
				k++;	
			}

		}
	}
}