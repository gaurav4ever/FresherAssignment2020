package question4;

public class items {
	
	private String name;
	private int quantity;
	private float price;
	private String type;
	
	public items() {}
	
	public items(String name, int quantity, float price, String type) {
		this.name=name;
		this.quantity=quantity;
		this.price= price;
		this.type=type;
	}
	
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public float calculateTax(float price, String type) {
		float tax=0.0f;

		if(type.equals("raw")) {
				raw rawItem = new raw();
				tax=rawItem.calculateTax(price);
			}
		else if(type.equals("manufactured")) {
			manufactured manufacturedItem = new manufactured();
			tax=manufacturedItem.calculateTax(price);
			}
		else if(type.equals("imported")) {
				imported importedItem = new imported();
				tax=importedItem.calculateTax(price);
			}
		
		return tax;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", quantity=" + quantity + ", price=" + price + ", type=" + type + "]";
	}
	
	
}
