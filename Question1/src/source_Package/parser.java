package source_Package;

//This class is used to parse input and check each parameter for correct/appropriate values
public class parser {
	
	private String name,type;
	private int quantity;
	private double price;
	
	int parse_me(String str)
	{
		str = str.trim();
		str += "$";
		if(!str.contains("-name"))
		{
			name = "NA";
		}
		else
		{
			name = extract(str,str.indexOf("-name")+5);
			if("name".equals(""))
			{
				System.out.println("Name Field Empty after -name");
				return -1;
			}
		}
		if(!str.contains("-type"))
		{
			System.out.println("Type Field Empty");
			return -1;
		}
		else
		{
			type = extract(str,str.indexOf("-type")+5);
			if(type.equals("") || (!type.equals("imported") && !type.equals("manufactured") && !type.contentEquals("raw")))
			{
				System.out.println("Invalid Entry in Type Field");
				return -1;
			}
		}
		if(!str.contains("-quantity"))
		{
			quantity = 0;
		}
		else
		{
			try
			{
				quantity = Integer.parseInt(extract(str,str.indexOf("-quantity")+9));
				if(quantity<0)
				{
					System.out.println("Negative Value of Quantity");
					return -1;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Entry in quantity field");
				return -1;
			}
		}
		if(!str.contains("-price"))
		{
			price = 0;
		}
		else
		{
			try
			{
				price = Double.parseDouble(extract(str,str.indexOf("-price")+6));
				if(price<0.00)
				{
					System.out.println("Negative Value of Price");
					return -1;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Entry in price field");
				return -1;
			}
		}
		return 1;
	}

    public static String extract(String item,int pos)
    {
        StringBuilder sbr = new StringBuilder("");
        for(int i=pos;item.charAt(i)!='-' && item.charAt(i)!='$';++i)
        {
            sbr.append(item.charAt(i));
        }
        String str = sbr.toString().trim();
        return str;
    }
    
    public String get_name()
    {
    	return name;
    }
    
    public String get_type()
    {
    	return type;
    }
    
    public int get_quantity()
    {
    	return quantity;
    }
    
    public double get_price()
    {
    	return price;
    }
}
