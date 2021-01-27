package question1;

public class item {
	private String name;
	private int quantity;
	private float price;
	private String type;
	private float finalPrice;
	
	public item() {}
	
	public item(String name, int quantity, float price, String type) {
		this.name=name;
		this.quantity=quantity;
		this.price=price;
		this.type=type;
		this.finalPrice=(price+new item().calculateTax(price,type))*quantity;
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
	
	public float getFinalPrice()
	{
		return finalPrice;
	}

	public float calculateTax(float price, String type) {
		float tax =0.0f;
		
		if("raw".equals(type)) {
		    raw rawItem= new raw();
		    tax=rawItem.calculateTax(price);
		}
		else if("manufactured".equals(type)) {
		    manufactured manufacturedItem = new manufactured();
		    tax=manufacturedItem.calculateTax(price);
		}
		else if("imported".equals(type)) {
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
