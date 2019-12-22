package question3;

import java.util.ArrayList;
import java.util.Iterator;

public class checkCycle {
	
	public boolean checkCycleUtils(ArrayList<Integer>depGraph[],int id1, int id2,boolean visited[],boolean ancestors[]) {
		
		if(ancestors[id1])
			return true;
		
		if(visited[id1])
			return false;
		
		visited[id1]=true;
		ancestors[id1]=true;
		Iterator<Integer> i = depGraph[id1].listIterator(); 
		
        	while (i.hasNext()) 
		{
            	    int n = i.next();
            	    if (checkCycleUtils(depGraph,n,id2,visited,ancestors))
            		return true;
        	} 
        	ancestors[id1]=false;
       		return false;
	}

	public boolean checkCycles(ArrayList<Integer>depGraph[], int id1, int id2, int vertices) {
		
		boolean visited[]= new boolean[vertices];
		boolean ancestors[]= new boolean[vertices];
		for(int j=0;j<vertices;j++){
			visited[j]=false;
			ancestors[j]=false;
		}	
		return checkCycleUtils(depGraph,id1,id2,visited,ancestors);
	}
}
