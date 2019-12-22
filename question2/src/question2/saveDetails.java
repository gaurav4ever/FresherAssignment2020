package question2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

public class saveDetails {
	
	public void save() {
		try {
			FileOutputStream file = new FileOutputStream("userdata.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject((ArrayList<user>) addUser.users);
		} catch (IOException e) {
			System.out.println("IO Exception Caught ");
		}
		System.out.println("Saved to disk");
	}

}
