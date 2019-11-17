/*
 * Created by Manu KJ 
 */
package Assignment1;

import java.util.List;

public class Assignment1 {

	public static int main(String[] args) throws Exception {
		ParseArguments parameter;

		// parse the command line arguments in the constructor
		parameter = new ParseArguments(args);
		parameter.getMoreInput();
		List<Items> items = parameter.getItems();

		for (Items item : items) {
			item.calculate_tax();
			item.display_iteam_info();
		}
		return 1;

	}

}
