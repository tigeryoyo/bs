package 笔试;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		try {
			InetAddress address =InetAddress.getLocalHost();
			System.out.println(address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static class Cmp {
		
		public Cmp() {}
		
	    public int cmp(int g1, int g2, int[][] records, int n) {
	    	
	    	Arrays.sort(records, new Comparator<Object>(){

				@Override
				public int compare(Object o1, Object o2) {
					int[] t1 = (int[])o1;
					int[] t2 = (int[])o2;
					return t1[0]-t2[0];
				}
	    		
	    	});
	    	Node[] heads = new Node[100];
	    	for(int i=0; i<n; i++){
	    		if(heads[records[i][0]] != null){
	    			heads[records[i][0]].setFlag(records[i][1]);
	    		}else{
	    			heads[records[i][0]] = new Node(records[i]);
	    		}
	    	}
	    	
	    	if(heads[g1] == null && heads[g2] == null){
	    		return 0;
	    	} 
	    	
	    	if(heads[g1] != null){
	    		if(find(heads,heads[g1].qList,g2)){
		    		return 1;
		    	}
	    	}
	    	
	    	if(heads[g2] != null){
	    		if(find(heads,heads[g2].qList,g1)){
		    		return -1;
		    	}
	    	}
	    	
	    	return 0;
	    }
	    
	    public boolean find(Node[] heads, boolean[] g1List, int j){
	    	if(g1List[j]){
	    		return true;
	    	} else {
	    		for(int k=1; k<100; k++){
	    			if(g1List[k]){
	    				if(heads[k] != null){
	    					return find(heads, heads[k].qList, j);
	    				}
	    			}
	    		}
	    	}
	    	return false;
	    }
	    
	    class Node{
	    	public boolean[] qList;
	    	public Node(int[] v){
	    		qList = new boolean[100];
	    		qList[v[1]] = true;
	    	}
	    	public void setFlag(int i){
	    		qList[i] = true;
	    	}
	    }
	    
	}
	
}

