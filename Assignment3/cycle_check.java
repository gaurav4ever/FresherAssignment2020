

import java.util.HashSet;
import java.util.HashMap;

class cycle_check {

	int pid,cid,root,req;
	HashSet<Integer> child_pid;
	HashSet<Integer> parent_pid;
	HashMap<Integer,Node> hashmap;
	boolean present;

	cycle_check(HashMap<Integer,Node> hashmap)
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

	void find_all_ancestors(Node r,int req)
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
		Node n = hashmap.get(nodeid);
		n.parent_nodes.forEach((r) -> find_all_ancestors(r,req));
	}

	void find_all_descendants(Node r,int req)
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
		Node n = hashmap.get(nodeid);
		n.child_nodes.forEach((r)->find_all_descendants(r,req));
	}


}
