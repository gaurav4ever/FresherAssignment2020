package FresherAssignment2020.Assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Operations {

	ArrayList<Node> root;
	HashMap<Integer,Node> hashmap;
	cycle_check cc;
	String pname,cname;

	public Operations(ArrayList<Node> root,HashMap<Integer,Node> hashmap)
	{
		this.root = root;
		this.hashmap = hashmap;
		cc = new cycle_check(hashmap);
	}

	void add(int pid,int cid,Scanner sc)
	{
		if(!hashmap.containsKey(pid) && !hashmap.containsKey(cid) && cid!=pid)
		{
			System.out.println("Parent Name :");
			pname = sc.nextLine();
			System.out.println("Child Name :");
			cname = sc.nextLine();
			Node pnode = new Node(pname,pid);
			Node cnode = new Node(cname,cid);
			pnode.child_nodes.add(cnode);
			cnode.parent_nodes.add(pnode);
			root.add(pnode);
			hashmap.put(pid,pnode);
			hashmap.put(cid,cnode);

		}
		else if(hashmap.containsKey(pid) && !hashmap.containsKey(cid))
		{
			System.out.println("Child Name :");
			cname = sc.nextLine();
			Node cnode = new Node(cname,cid);
			Node pnode = hashmap.get(pid);
			pnode.child_nodes.add(cnode);
			cnode.parent_nodes.add(pnode);
			hashmap.put(cid,cnode);

		}
		else if(!hashmap.containsKey(pid) && hashmap.containsKey(cid))
		{
			System.out.println("Parent Name :");
			pname = sc.nextLine();
			Node pnode = new Node(pname,pid);
			Node cnode = hashmap.get(cid);
			pnode.child_nodes.add(cnode);
			cnode.parent_nodes.add(pnode);
			root.add(pnode);
			hashmap.put(pid,pnode);
			if(root.contains(cnode))
			{
				root.remove(cnode);
			}

		}
		else if(hashmap.containsKey(pid) && hashmap.containsKey(cid))
		{
			Node pnode = hashmap.get(pid);
			Node cnode = hashmap.get(cid);
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

				}
			}
		}

	}

	void get_immediate_children(int nodeid)
	{
		if(hashmap.containsKey(nodeid))
		{
			Node n = hashmap.get(nodeid);
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
			Node n = hashmap.get(nodeid);
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
			Node n = hashmap.get(nodeid);
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

	void find_all_descendants(Node r)
	{
		System.out.println(r.name+" "+r.n_id);
		r.child_nodes.forEach((f)-> find_all_descendants(f));
	}

	void get_ancestors(int nodeid)
	{
		if(hashmap.containsKey(nodeid))
		{
			Node n = hashmap.get(nodeid);
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

	void find_all_ancestors(Node r)
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
			Node n = new Node(nodename,nodeid);
			hashmap.put(nodeid,n);
			root.add(n);
		}
	}

	void delete_node(Node root)
	{
		root.child_nodes.forEach((r) -> delete_node(r));
		hashmap.remove(root.n_id);
		root.child_nodes.clear();
		root.parent_nodes.clear();
	}

	void delete_dependency(int pid,int cid)
	{
		Node pnode = hashmap.get(pid);
		Node cnode = hashmap.get(cid);
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
			Node temp = pnode;
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
				Node temp = pnode;
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