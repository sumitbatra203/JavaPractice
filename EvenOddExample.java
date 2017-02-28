package geeksForgeeks;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddExample{
	
	public static void main(String[] args) {
		
		int arr[]={1,2,3,4,5,6,7,8,9};
		AtomicBoolean oddPrinted=new AtomicBoolean(false);
		AtomicBoolean evenPrinted=new AtomicBoolean(true);
		AtomicInteger size=new AtomicInteger(arr.length);
		AtomicInteger index=new AtomicInteger(0);
		Thread oddThread=new Thread(new OddThread(arr,oddPrinted,evenPrinted,size,index));
		Thread evenThread=new Thread(new EvenThread(arr,oddPrinted,evenPrinted,size,index));
		oddThread.setName("oddThread");
		evenThread.setName("evenThread");
		oddThread.start();
		evenThread.start();
	
	}
	
}

class OddThread implements Runnable{
	int arr[];
	AtomicBoolean oddPrinted,evenPrinted;
	AtomicInteger size,index;
	OddThread(int arr[],AtomicBoolean oddPrinted,AtomicBoolean evenPrinted,AtomicInteger size,AtomicInteger index){
		this.arr=arr;
		this.evenPrinted=evenPrinted;
		this.oddPrinted=oddPrinted;
		this.size=size;
		this.index=index;
	}
	@Override
	public void run() {						
		while(size.get()>0){
			synchronized (arr) {
				if(evenPrinted.get()){
				System.out.println("odd----"+Thread.currentThread().getName()+"-------"+arr[index.get()]);
				index.incrementAndGet();
				size.decrementAndGet();
				oddPrinted.set(true);
				evenPrinted.set(false);
				arr.notifyAll();
				try {
					arr.wait();
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
				}else{
					arr.notifyAll();
				}				
			}	
		}
		
	}
}


class EvenThread implements Runnable{
	int arr[];
	AtomicBoolean oddPrinted,evenPrinted;
	AtomicInteger size,index;
	EvenThread(int arr[],AtomicBoolean oddPrinted,AtomicBoolean evenPrinted,AtomicInteger size,AtomicInteger index){
		this.arr=arr;
		this.evenPrinted=evenPrinted;
		this.oddPrinted=oddPrinted;
		this.size=size;
		this.index=index;
	}
	@Override
	public void run() {		
		while(size.get()>0){
			synchronized (arr) {
				if(oddPrinted.get()){
					System.out.println("even----"+Thread.currentThread().getName()+"-------"+arr[index.get()]);
					index.incrementAndGet();
				size.decrementAndGet();
				oddPrinted.set(false);
				evenPrinted.set(true);
				arr.notifyAll();
				try {
					arr.wait();
				} catch (InterruptedException e) {				
					e.printStackTrace();
				}
				}else{
					arr.notifyAll();
				}				
			}	
		}
				
	}
}
