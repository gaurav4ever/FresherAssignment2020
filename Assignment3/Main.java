package FresherAssignment2020.Assignment3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{

	public static void main(String[] args) {

		ArrayList<Node> root = new ArrayList<>();
		HashMap<Integer,Node> hashmap = new HashMap<>();
		String res="8";
		int pid,cid,response;

		Operations o = new Operations(root,hashmap);
		Scanner sc = new Scanner(System.in);

		while(!res.equals("9"))
		{
			System.out.println("Get immediate parents : 1");
			System.out.println("Get immediate children : 2");
			System.out.println("Find all ancestors : 3");
			System.out.println("Find all Descendants : 4");
			System.out.println("Delete a dependency : 5");
			System.out.println("Delete a node : 6");
			System.out.println("Add dependency : 7");
			System.out.println("Add a new node : 8");
        System.out.println("Exit : 9");
        res = sc.nextLine();
        switch(res)
        {
			case "1" : System.out.println("Enter Node id");
				try {
					response = Integer.parseInt(sc.nextLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Exception Occur While Entering for Immediate Parents");
					break;
				}
				o.get_immediate_parents(response);
				break;

			case "2" : System.out.println("Enter Node id");
				try {
					response = Integer.parseInt(sc.nextLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Exception occur while entering for Immediate Children");
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
					System.out.println("Exception Occur While Entering for Ancestors");
					break;
				}
				o.get_ancestors(response);
				break;
			case "4" : System.out.println("Enter Node id");
				try {
					response = Integer.parseInt(sc.nextLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Exception Occur While Entering for Descendants");
					break;
				}
				o.get_descendants(response);
				break;
			case "5" : System.out.println("Enter Parent id");
				try
				{
					pid = Integer.parseInt(sc.nextLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Exception occur while enetring parent id");
					break;
				}
				System.out.println("Enter Child id");
				try
				{
					cid = Integer.parseInt(sc.nextLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Exception occur while enetring child id");
					break;
				}
				o.delete_dependency(pid, cid);
			case "6" : System.out.println("Enter Node id");
				try {
					response = Integer.parseInt(sc.nextLine());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Exception occur while adding node id");
					break;
				}
				if(hashmap.containsKey(response))
				{
					Node n = hashmap.get(response);
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
			case "7" : System.out.println("Enter Parent id");
        			   try
        			   {
        				   pid = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Exception occur while entering parent id");
        				   break;
        			   }
        			   System.out.println("Enter Child ID");
        			   try{
        				   cid = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Exception occur while entering child id");
        				   break;  
        			   }
        			   o.add(pid,cid,sc)

        			   break;


        	case "8" : System.out.println("Enter Node id");
        			   try {
        				   response = Integer.parseInt(sc.nextLine());
        			   }
        			   catch(NumberFormatException e)
        			   {
        				   System.out.println("Exception Occur While Entering for Adding Single Node");
        				   break;
        			   }
        			   System.out.println("Enter Node name");
        			   String name = sc.nextLine();
        			   o.add_single_node(name,response);
        			   break;


        	case "9" : break;
        	default : System.out.println("Please enter between 1 and 9");
        }

		}

		hashmap.clear();
		sc.close();

	}

}