package source_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//It contains all options that were required to be performed
//There is one function for each operation

public class operations {

	ArrayList<node> root;
	HashMap<Integer,node> hm;
	cycle_check cc;
	String pname,cname;
	
	public operations(ArrayList<node> root,HashMap<Integer,node> hm)
	{
		this.root = root;
		this.hm = hm;
		cc = new cycle_check(hm);
	}
	
	int add(int pid,int cid,Scanner sc)
	{
		if(!hm.containsKey(pid) && !hm.containsKey(cid) && cid!=pid)
		{
			System.out.println("Enter Parent Name");
			pname = sc.nextLine();
			System.out.println("Enter Child Name");
			cname = sc.nextLine();
			node pnode = new node(pname,pid);
			node cnode = new node(cname,cid);
			pnode.front_nodes.add(cnode);
			cnode.back_nodes.add(pnode);
			root.add(pnode);
			hm.put(pid,pnode);
			hm.put(cid,cnode);
			return 1;
		}
		else if(hm.containsKey(pid) && !hm.containsKey(cid))
		{
			System.out.println("Enter Child Name");
			cname = sc.nextLine();
			node cnode = new node(cname,cid);
			node pnode = hm.get(pid);
			pnode.front_nodes.add(cnode);
			cnode.back_nodes.add(pnode);
			hm.put(cid,cnode);
			return 1;
		}
		else if(!hm.containsKey(pid) && hm.containsKey(cid))
		{
			System.out.println("Enter Parent Name");
			pname = sc.nextLine();
			node pnode = new node(pname,pid);
			node cnode = hm.get(cid);
			pnode.front_nodes.add(cnode);
			cnode.back_nodes.add(pnode);
			root.add(pnode);
			hm.put(pid,pnode);
			if(root.contains(cnode))
			{
				root.remove(cnode);
			}
			return 1;
		}
		else if(hm.containsKey(pid) && hm.containsKey(cid))
		{
			node pnode = hm.get(pid);
			node cnode = hm.get(cid);
			if(pnode.front_nodes.contains(cnode) || cnode.front_nodes.contains(pnode))
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
					pnode.front_nodes.add(cnode);
					cnode.back_nodes.add(pnode);
					return 1;
				}
			}
		}
		return 0;
	}
	
	void get_immediate_children(int nodeid)
	{
		if(hm.containsKey(nodeid))
		{
			node n = hm.get(nodeid);
			if(n.front_nodes.size()>0)
			{
				System.out.println("Printing Children");
				n.front_nodes.forEach((node)-> System.out.println(node.name));
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
		if(hm.containsKey(nodeid))
		{
			node n = hm.get(nodeid);
			if(n.back_nodes.size()>0)
			{
				System.out.println("Printing Parents");
				n.back_nodes.forEach((node)-> System.out.println(node.name));
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
		if(hm.containsKey(nodeid))
		{
			node n = hm.get(nodeid);
			if(n.front_nodes.size()>0)
			{
				n.front_nodes.forEach((r)->find_all_descendants(r));
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
		System.out.println(r.name+" "+r.node_id);
		r.front_nodes.forEach((f)-> find_all_descendants(f));
	}
	
	void get_ancestors(int nodeid)
	{
		if(hm.containsKey(nodeid))
		{
			node n = hm.get(nodeid);
			if(n.back_nodes.size()>0)
			{
				n.back_nodes.forEach((r) -> find_all_ancestors(r));
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
		System.out.println(r.name+" "+r.node_id);
		r.back_nodes.forEach((f) -> find_all_ancestors(f));
	}
	
	void add_single_node(String nodename,int nodeid)
	{
		if(hm.containsKey(nodeid))
		{
			System.out.println("Node Already Present in Graph");
		}
		else
		{
			node n = new node(nodename,nodeid);
			hm.put(nodeid,n);
			root.add(n);
		}
	}
	
	void delete_node(node root)
	{
		root.front_nodes.forEach((r) -> delete_node(r));
		hm.remove(root.node_id);
		root.front_nodes.clear();
		root.back_nodes.clear();
	}
	
	void delete_dependency(int pid,int cid)
	{
		node pnode = hm.get(pid);
		node cnode = hm.get(cid);
		if(!hm.containsKey(pid) && !hm.containsKey(cid))
		{
			System.out.println("Any One of the Nodes is not present in Graph");
			return;
		}
		if(pnode.front_nodes.contains(cnode) && cnode.back_nodes.contains(pnode))
		{
			;
		}
		else if(cnode.front_nodes.contains(pnode) && pnode.back_nodes.contains(cnode))
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
		if(pnode.back_nodes.size()==0)
		{
			if(pnode.front_nodes.size()==1)
			{
				delete_node(pnode);
			}
			else
			{
				pnode.front_nodes.remove(cnode);
				delete_node(cnode);
			}
		}
		else
		{
			if(pnode.front_nodes.size()==1)
			{
				node temp = pnode;
				pnode.back_nodes.forEach((n) -> n.front_nodes.remove(temp));
			}
			else
			{
				pnode.front_nodes.remove(cnode);
				delete_node(cnode);
			}
		}
		System.out.println("Dependency Deleted");
	}
}
