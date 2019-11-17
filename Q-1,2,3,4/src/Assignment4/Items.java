/*
 * Created by Manu KJ 	
 */
package Assignment4;

public class Items {
	private String name;
	private double price;
	private int quality;
	private String type;
	private double tax;

	public Items(String name, double price, int quality, String type) {
		this.name = name;
		this.price = price;
		this.quality = quality;
		this.type = type;
	}

	public double getTax() {
		return this.tax;
	}

	public String getName() {
		return name;
	}

//	    Function to calculate tax
	public void calculate_tax() {
		double import_tax = 0;
		double tot_price = 0;

		if (type.equals("raw")) {
			// raw: 12.5% of the item cost
			this.tax = (double) (0.125) * price;
		} else if (type.equals("manufactured")) {
			// manufactured: 12.5% of the item cost + 2% of (item cost + 12.5% of the item
			// cost)
			this.tax = (double) ((0.125) * price) + (0.2 * (price + (0.125 * price)));
		} else if (type.equals("imported")) {
			import_tax = (double) (0.1) * price;
			tot_price = price + import_tax;
			double super_charge = (tot_price <= 100) ? 5 : (tot_price <= 200) ? 10 : 0.5 * (tot_price);
			this.tax = import_tax + super_charge;
		}

	}

	public void display_iteam_info() {

		System.out.println("---------");
		System.out.println("Name : " + name);
		System.out.println("Price : " + price);
		System.out.println("Type : " + type);
		System.out.println("Quality : " + quality);
		System.out.println("tax : " + tax);
		System.out.println("Total Price : " + (price + tax));
		System.out.println("---------");

	}

}
