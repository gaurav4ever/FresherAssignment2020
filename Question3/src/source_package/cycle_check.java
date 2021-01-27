package source_package;

import java.util.HashSet;
import java.util.HashMap;

//It Checks For Cycles in Graph with Each Addition of Dependency
//It basically Checks if there are any common nodes while traversing either backwards or towards front for both nodes
public class cycle_check {
	
	int pid,cid,root,req;
	HashSet<Integer> front_pid;
	HashSet<Integer> back_pid;
	HashMap<Integer,node> hm;
	boolean found;
	
	cycle_check(HashMap<Integer,node> hm)
	{
		this.hm = hm;
		front_pid = new HashSet<>();
		back_pid = new HashSet<>();
	}
	
	int check(int pid,int cid)
	{
		front_pid.clear();
		back_pid.clear();
		get_ancestors(pid,1);
		found = false;
		get_ancestors(cid,2);
		if(found==true)
		{
			return 1;
		}
		get_descendants(pid,1);
		get_descendants(cid,2);
		if(found==true)
		{
			return 1;
		}
		return 0;
	}
	
	void find_all_ancestors(node r,int req)
	{
		if(req==1)
		{
			back_pid.add(r.node_id);
		}
		else
		{
			if(back_pid.contains(r.node_id))
			{
				found = true;
				return;
			}
		}
		r.back_nodes.forEach((f) -> find_all_ancestors(f,req));
	}
	
	void get_ancestors(int nodeid,int req)
	{
		node n = hm.get(nodeid);
		n.back_nodes.forEach((r) -> find_all_ancestors(r,req));
	}
	
	void find_all_descendants(node r,int req)
	{
		if(req==1)
		{
			front_pid.add(r.node_id);
		}
		else
		{
			if(front_pid.contains(r.node_id))
			{
				found = true;
				return;
			}
		}
		r.front_nodes.forEach((f)-> find_all_descendants(f,req));
	}
	
	void get_descendants(int nodeid,int req)
	{
		node n = hm.get(nodeid);
		n.front_nodes.forEach((r)->find_all_descendants(r,req));
	}
	

}
