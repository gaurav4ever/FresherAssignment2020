package source_Package;

//Tax is different for different types of items hence each class implements this interface
public interface tax {
	void calculate_tax(double price);
}
