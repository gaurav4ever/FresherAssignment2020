import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;

class node {
	
	String name;
	int n_id;
	ArrayList<node> parent_nodes;
	ArrayList<node> child_nodes;
	
	node(String name,int n_id)
	{
		this.name = name;
		this.n_id = n_id;
		child_nodes = new ArrayList<>();
		parent_nodes = new ArrayList<>();
	}
}

class cycle_check {
	
	int pid,cid,root,req;
	HashSet<Integer> child_pid;
	HashSet<Integer> parent_pid;
	HashMap<Integer,node> hashmap;
	boolean present;
	
	cycle_check(HashMap<Integer,node> hashmap)
	{
		this.hashmap = hashmap;
		child_pid = new HashSet<>();
		parent_pid = new HashSet<>();
	}
	
	int check(int pid,int cid)
	{
		child_pid.clear();
		parent_pid.clear();
		get_ancestors(pid,1);
		present = false;
		get_ancestors(cid,2);
		if(present==true)
		{
			return 1;
		}
		get_descendants(pid,1);
		get_descendants(cid,2);
		if(present==true)
		{
			return 1;
		}
		return 0;
	}
	
	void find_all_ancestors(node r,int req)
	{
		if(req==1)
		{
			parent_pid.add(r.n_id);
		}
		else
		{
			if(parent_pid.contains(r.n_id))
			{
				present = true;
				return;
			}
		}
		r.parent_nodes.forEach((f) -> find_all_ancestors(f,req));
	}
	
	void get_ancestors(int nodeid,int req)
	{
		node n = hashmap.get(nodeid);
		n.parent_nodes.forEach((r) -> find_all_ancestors(r,req));
	}
	
	void find_all_descendants(node r,int req)
	{
		if(req==1)
		{
			child_pid.add(r.n_id);
		}
		else
		{
			if(child_pid.contains(r.n_id))
			{
				present = true;
				return;
			}
		}
		r.child_nodes.forEach((f)-> find_all_descendants(f,req));
	}
	
	void get_descendants(int nodeid,int req)
	{
		node n = hashmap.get(nodeid);
		n.child_nodes.forEach((r)->find_all_descendants(r,req));
	}
	

}

class operations {

	ArrayList<node> root;
	HashMap<Integer,node> hashmap;
	cycle_check cc;
	String pname,cname;
	
	public operations(ArrayList<node> root,HashMap<Integer,node> hashmap)
	{
		this.root = root;
		this.hashmap = hashmap;
		cc = new cycle_check(hashmap);
	}
	
	int add(int pid,int cid,Scanner sc)
	{
		if(!hashmap.containsKey(pid) && !hashmap.containsKey(cid) && cid!=pid)
		{
			System.out.println("Parent Name :");
			pname = sc.nextLine();
			System.out.println("Child Name :");
			cname = sc.nextLine();
			node pnode = new node(pname,pid);
			node cnode = new node(cname,cid);
			pnode.child_nodes.add(cnode);
			cnode.parent_nodes.add(pnode);
			root.add(pnode);
			hashmap.put(pid,pnode);
			hashmap.put(cid,cnode);
			return 1;
		}
		else if(hashmap.containsKey(pid) && !hashmap.containsKey(cid))
		{
			System.out.println("Child Name :");
			cname = sc.nextLine();
			node cnode = new node(cname,cid);
			node pnode = hashmap.get(pid);
			pnode.child_nodes.add(cnode);
			cnode.parent_nodes.add(pnode);
			hashmap.put(cid,cnode);
			return 1;
		}
		else if(!hashmap.containsKey(pid) && hashmap.containsKey(cid))
		{
			System.out.println("Parent Name :");
			pname = sc.nextLine();
			node pnode = new node(pname,pid);
			node cnode = hashmap.get(cid);
			pnode.child_nodes.add(cnode);
			cnode.parent_nodes.add(pnode);
			root.add(pnode);
			hashmap.put(pid,pnode);
			if(root.contains(cnode))
			{
				root.remove(cnode);
			}
			return 1;
		}
		else if(hashmap.containsKey(pid) && hashmap.containsKey(cid))
		{
			node pnode = hashmap.get(pid);
			node cnode = hashmap.get(cid);
			if(pnode.child_nodes.contains(cnode) || cnode.child_nodes.contains(pnode))
			{
				System.out.println("Link Already Present");
			}
			else
			{
				if(cc.check(pid, cid)==1)
				{
					System.out.println("Creating Edge will lead to Cycles in Graph! Cant Create");
				}
				else
				{
					pnode.child_nodes.add(cnode);
					cnode.parent_nodes.add(pnode);
					return 1;
				}
			}
		}
		return 0;
	}
	
	void get_immediate_children(int nodeid)
	{
		if(hashmap.containsKey(nodeid))
		{
			node n = hashmap.get(nodeid);
			if(n.child_nodes.size()>0)
			{
				System.out.println("Printing Children...");
				n.child_nodes.forEach((node)-> System.out.println(node.name));
			}
			else
			{
				System.out.println("No Children Present");
			}
		}
		else
		{
			System.out.println("Node Not Present in Graph");
		}
	}

	void get_immediate_parents(int nodeid)
	{
		if(hashmap.containsKey(nodeid))
		{
			node n = hashmap.get(nodeid);
			if(n.parent_nodes.size()>0)
			{
				System.out.println("Printing Parents");
				n.parent_nodes.forEach((node)-> System.out.println(node.name));
			}
			else
			{
				System.out.println("No Parents Present");
			}
		}
		else
		{
			System.out.println("Node Not Present in Graph");
		}
	}
	
	void get_descendants(int nodeid)
	{
		if(hashmap.containsKey(nodeid))
		{
			node n = hashmap.get(nodeid);
			if(n.child_nodes.size()>0)
			{
				n.child_nodes.forEach((r)->find_all_descendants(r));
			}
			else
			{
				System.out.println("No Children Present");
			}
		}
		else
		{
			System.out.println("Node Not Present in Graph");
		}
	}
	
	void find_all_descendants(node r)
	{
		System.out.println(r.name+" "+r.n_id);
		r.child_nodes.forEach((f)-> find_all_descendants(f));
	}
	
	void get_ancestors(int nodeid)
	{
		if(hashmap.containsKey(nodeid))
		{
			node n = hashmap.get(nodeid);
			if(n.parent_nodes.size()>0)
			{
				n.parent_nodes.forEach((r) -> find_all_ancestors(r));
			}
			else
			{
				System.out.println("No Parent Present");
			}
		}
		else
		{
			System.out.println("Node Not Present In Graph");
		}
	}
	
	void find_all_ancestors(node r)
	{
		System.out.println(r.name+" "+r.n_id);
		r.child_nodes.forEach((f) -> find_all_ancestors(f));
	}
	
	void add_single_node(String nodename,int nodeid)
	{
		if(hashmap.containsKey(nodeid))
		{
			System.out.println("Node Already Present in Graph");
		}
		else
		{
			node n = new node(nodename,nodeid);
			hashmap.put(nodeid,n);
			root.add(n);
		}
	}
	
	void delete_node(node root)
	{
		root.child_nodes.forEach((r) -> delete_node(r));
		hashmap.remove(root.n_id);
		root.child_nodes.clear();
		root.parent_nodes.clear();
	}
	
	void delete_dependency(int pid,int cid)
	{
		node pnode = hashmap.get(pid);
		node cnode = hashmap.get(cid);
		if(!hashmap.containsKey(pid) && !hashmap.containsKey(cid))
		{
			System.out.println("Any One of the Nodes is not present in Graph");
			return;
		}
		if(pnode.child_nodes.contains(cnode) && cnode.parent_nodes.contains(pnode))
		{
			;
		}
		else if(cnode.child_nodes.contains(pnode) && pnode.parent_nodes.contains(cnode))
		{
			node temp = pnode;
			pnode = cnode;
			cnode = temp;
		}
		else
		{
			System.out.println("Link Between Nodes doesnt exist or isnt proper");
			return;
		}
		if(pnode.parent_nodes.size()==0)
		{
			if(pnode.child_nodes.size()==1)
			{
				delete_node(pnode);
			}
			else
			{
				pnode.child_nodes.remove(cnode);
				delete_node(cnode);
			}
		}
		else
		{
			if(pnode.child_nodes.size()==1)
			{
				node temp = pnode;
				pnode.parent_nodes.forEach((n) -> n.child_nodes.remove(temp));
			}
			else
			{
				pnode.child_nodes.remove(cnode);
				delete_node(cnode);
			}
		}
		System.out.println("Dependency Deleted");
	}
}


public class Solution3 {

	public static void main(String[] args) {

		ArrayList<node> root = new ArrayList<>();
		HashMap<Integer,node> hashmap = new HashMap<>();
		String res="8";
		int pid,cid,response;
		
		operations o = new operations(root,hashmap);
		Scanner sc = new Scanner(System.in);
		
		while(!res.equals("9"))
		{
		System.out.println("Add dependency : 1");
        System.out.println("Get immediate children : 2");
        System.out.println("Get immediate parents : 3");
        System.out.println("Find all ancestors : 4");
        System.out.println("Find all Descendants : 5");
        System.out.println("Add a new node : 6");
        System.out.println("Delete a node : 7");
        System.out.println("Delete a dependency : 8");
        System.out.println("Exit : 9");
        res = sc.nextLine();
        switch(res)
        {
        	case "1" : System.out.println("Enter Parent id");
        			   try
        			   {
        				   pid = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Invalid Entry While Entering Parent ID");
        				   break;
        			   }
        			   System.out.println("Enter Child ID");
        			   try{
        				   cid = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Invalid Entry While Entering Parent ID");
        				   break;  
        			   }
        			   if(o.add(pid,cid,sc)==1)
        			   {
        				   System.out.println("Inserted Node Successfully");
        			   }
        			   else
        			   {
        				   System.out.println("Error While Inserting");
        			   }
        			   break;
        	case "2" : System.out.println("Enter Node id");
        			   try {
        				   response = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Invalid Entry While Entering for Immediate Children");
        				   break;
        			   }
        			   o.get_immediate_children(response);
        			   break;
        	case "3" : System.out.println("Enter Node id");
			   		   try {
			   			   response = Integer.parseInt(sc.nextLine());
			   		   }
			   		   catch(NumberFormatException e)
			   		   {
			   			   System.out.println("Invalid Entry While Entering for Immediate Parents");
			   			   break;
			   		   }
			   		   o.get_immediate_parents(response);
			   		   break; 
        	case "4" : System.out.println("Enter Node id");
			   		   try {
			   			   response = Integer.parseInt(sc.nextLine());
			   		   }
			   		   catch(NumberFormatException e)
			   		   {
			   			   System.out.println("Invalid Entry While Entering for Ancestors");
			   			   break;
			   		   }
			   		   o.get_ancestors(response);
			   		   break;
        	case "5" : System.out.println("Enter Node id");
			   		   try {
			   			   response = Integer.parseInt(sc.nextLine());
			   		   }
			   		   catch(NumberFormatException e)
			   		   {
			   			   System.out.println("Invalid Entry While Entering for Descendants");
			   			   break;
			   		   }
			   		   o.get_descendants(response);
			   		   break;
        	case "6" : System.out.println("Enter Node id");
        			   try {
        				   response = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Invalid Entry While Entering for Adding Single Node");
        				   break;
        			   }
        			   System.out.println("Enter Node name");
        			   String name = sc.nextLine();
        			   o.add_single_node(name,response);
        			   break;
        	case "7" : System.out.println("Enter Node id");
	   		  		   try {
	   		  			   response = Integer.parseInt(sc.nextLine());
	   		  		   }
	   		  		   catch(NumberFormatException e)
	   		  		   {
	   		  			   System.out.println("Invalid");
	   		  			   break;
	   		  		   }
	   		  		   if(hashmap.containsKey(response))
	   		  		   {
	   		  			   node n = hashmap.get(response);
	   		  			   if(n.parent_nodes.size()==0)
	   		  			   {
	   		  				   o.delete_node(n);
	   		  			   }
	   		  			   else if(n.child_nodes.size()==0)
	   		  			   {
	   		  				   n.parent_nodes.forEach((bn) -> bn.child_nodes.remove(n));   
	   		  				   n.parent_nodes.clear();
	   		  				   n.child_nodes.clear();
	   		  				   hashmap.remove(n.n_id);
	   		  			   }
	   		  			   else
	   		  			   {
	   		  				   n.parent_nodes.forEach((bn) -> bn.child_nodes.remove(n));
	   		  				   o.delete_node(n);
	   		  			   }
	   		  			   System.out.println("Node Deleted.");
	   		  		   }
	   		  		   else
	   		  		   {
	   		  			   System.out.println("Node Not Present in Graph");
	   		  		   }
        	case "8" : System.out.println("Enter Parent id");
        			   try
        			   {
        				   pid = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Invalid Entry!Try Again");
        				   break;
        			   }
        			   System.out.println("Enter Child id");
        			   try
        			   {
        				   cid = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Invalid Entry!Try Again");
        				   break;
        			   }
        			   o.delete_dependency(pid, cid);
        	case "9" : break;
        	default : System.out.println("Please enter between 1 and 9");
        }
        
		}
		
		hashmap.clear();
		sc.close();
		
	}

}