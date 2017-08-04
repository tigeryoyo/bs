package jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMbject {

	static class BigObject {
		public int[] placeholder = new int[64*1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException {
		List<BigObject> list = new ArrayList<BigObject>();
		for(int i=0; i<num; i++){
			Thread.sleep(50);
			list.add(new BigObject());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] a = new String[5];
		System.out.println(a[0]);
	}

}
