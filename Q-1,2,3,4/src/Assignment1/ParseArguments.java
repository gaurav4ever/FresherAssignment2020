/*
 * Created by Manu KJ 
 */
package Assignment1;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseArguments {

	private List<Items> items = new ArrayList<Items>();
	private Map<String, String> params;
	private Items inventoryManagementSystem;
	private Scanner sc = new Scanner(System.in);

//	constructor
	public ParseArguments(String args[]) throws Exception {

		// where the command line argument is parsed
		if (args.length > 0) {
			params = parseArguments(args);
			inventoryManagementSystem = new Items(params);
			this.items.add(inventoryManagementSystem);
		} else {
			System.out.println("no Command Line Argument is passed \n");
		}

	}

	// function to parse the arguments
	private Map<String, String> parseArguments(String[] args) throws Exception {

		params = new HashMap<String, String>();

		for (int i = 0; (i < args.length) && (args.length % 2 == 0); i += 2) {
			if (args[i].charAt(0) == '-') {
				String key = args[i].substring(1);
				String value = args[i + 1];
				params.put(key, value);
			}
		}
		if (params.containsKey("type") == false) {
			throw new Exception("Type option is Mandatory");
		}
		return params;
	}

	// Function to add more items
	public void getMoreInput() throws Exception {

		while (true) {
			System.out.println("Do you want to enter details of new item (Y/N)");
			char choice = sc.next().charAt(0);
			// neglect the newline i,e \n character after
			sc.nextLine();

			if (choice == 'Y') {
				System.out.print(
						"Enter the item name, item type, item prize and item Quality as -name name_value -item item_value -type item_types -price item_price\n");
				String string = sc.nextLine();
				String args[] = string.split(" ");

				params = parseArguments(args);
				inventoryManagementSystem = new Items(params);
				items.add(inventoryManagementSystem);

			} else {
				sc.close();
				return;
			}
		}

	}

	// returns all the items
	List<Items> getItems() {
		return items;
	}
}
