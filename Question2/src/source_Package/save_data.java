package source_Package;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;

//To save data by serializing them
//It serializes ArrayLists and saves them as a whole
public class save_data {
	
	String file;
	ArrayList<student> a = new ArrayList<>();
	
	save_data(String file)
	{
		this.file = file;
	}
	
	//To Read data
	int pop_data()
	{
        try{
                FileInputStream fis = new FileInputStream(file);
                if(fis.available() > 0)
                {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    a = (ArrayList<student>)ois.readObject();
                    System.out.println("Past data Loaded");
                    return 1;
                }
                else
                {
                    System.out.println("Source File Empty");
                }
        }
        catch(IOException | ClassNotFoundException e)
        {
                System.out.println(e.getStackTrace());
        }
        return 0;
	}
	
	//Returns the ArrayList after reading from file
	ArrayList<student> get_list()
	{
		return a;
	}
	
	//To Write Data to file
	void push_data(ArrayList<student> pd)
	{
		try{
    		FileOutputStream fos = new FileOutputStream(file);
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
    		oos.writeObject(pd);
    		System.out.println("Saved");
			}
			catch(IOException e)
			{
					System.out.println("Error in Saving");
					System.out.println(e.getStackTrace());
			}
	}
}
