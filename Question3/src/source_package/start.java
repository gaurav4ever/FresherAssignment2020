package source_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class start {

	
//Menu Driven Program was created for easy user interface and handling of all operations at one place	
	public static void main(String[] args) {

		ArrayList<node> root = new ArrayList<>();
		HashMap<Integer,node> hm = new HashMap<>();
		String res="8";
		int pid,cid,response;
		
		operations o = new operations(root,hm);
		Scanner sc = new Scanner(System.in);
		
		while(!res.equals("9"))
		{
		System.out.println("Press 1 to add dependency");
        System.out.println("Press 2 to get immediate children");
        System.out.println("Press 3 to get immediate parents");
        System.out.println("Press 4 to find all ancestors");
        System.out.println("Press 5 to find all Descendants");
        System.out.println("Press 6 to add a new node");
        System.out.println("Press 7 to delete a node");
        System.out.println("Press 8 to delete a dependency");
        System.out.println("Press 9 to exit");
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
	   		  			   System.out.println("Invalid Entry While Entering for Adding Single Node");
	   		  			   break;
	   		  		   }
	   		  		   if(hm.containsKey(response))
	   		  		   {
	   		  			   node n = hm.get(response);
	   		  			   if(n.back_nodes.size()==0)
	   		  			   {
	   		  				   o.delete_node(n);
	   		  			   }
	   		  			   else if(n.front_nodes.size()==0)
	   		  			   {
	   		  				   n.back_nodes.forEach((bn) -> bn.front_nodes.remove(n));   
	   		  				   n.back_nodes.clear();
	   		  				   n.front_nodes.clear();
	   		  				   hm.remove(n.node_id);
	   		  			   }
	   		  			   else
	   		  			   {
	   		  				   n.back_nodes.forEach((bn) -> bn.front_nodes.remove(n));
	   		  				   o.delete_node(n);
	   		  			   }
	   		  			   System.out.println("Deleted");
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
        	default : System.out.println("Invalid Entry!Try Again.");
        }
        
		}
		System.out.println("Deallocating Resources");
		hm.clear();
		sc.close();
		System.out.println("Terminating");
	}

}
