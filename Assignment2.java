package Assignment2;

import java.util.*;
import java.io.*;
class Student implements Serializable {
	private String name;
	private int age;
	private String address;
	private int rollno;
	private Set<Character> courses=new HashSet<Character>();
	Student(String name,int age,String address,int rollno,Set<Character> courses) {
		this.name=name;
		this.age=age;
		this.address=address;
		this.rollno=rollno;
		this.courses=courses;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getRollno() {
		return rollno;
	}
	public String getAddress() {
		return address;
	}
	public Set<Character> getCourses() {
		return courses;
	}
}
class compareByName implements Comparator<Student> {
	@Override
	public int compare(Student obj1, Student obj2) {
		int res = obj1.getName().compareTo(obj2.getName());
		if(res==0) {
			return obj1.getRollno()-obj2.getRollno();
		}
		return res;
	}
}
//compare two Student objects based on selected sorting field
class compareList implements Comparator<Student> {
	private int sortingField;
	@Override
	public int compare(Student obj1,Student obj2) {
		int diff=0;
		switch(sortingField) {
		case 1:diff = obj1.getName().compareTo(obj2.getName());
		       break;
		case 2:diff = obj1.getAge()-obj2.getAge();
		       break;
		case 3:diff = obj1.getAddress().compareTo(obj2.getAddress());
		       break;
		case 4:diff = obj1.getRollno()-obj2.getRollno();
		       break;
		}
		return diff;
	}
	public void setField(int field) {
		this.sortingField=field;
	}
}
class AddDetails {
	Scanner sc = new Scanner(System.in);
	static Set<Integer> rollSet=new HashSet<Integer>();
	public Student addStudent() {
		String name="";
		String address="";
		int rollno=0;
		int age=0;
		Set<Character> courses = new HashSet<Character>();
		System.out.println("Enter full name:");
		name=sc.nextLine();
		if(name=="") {
			System.out.println("name field is mandatory!");
			System.exit(0);
		}
		System.out.println("Enter age:");
		try {
			age=Integer.parseInt(sc.next());
		} catch(NumberFormatException e) {
			System.out.println("Enter a valid age!");
			System.exit(0);
		}
		System.out.println("Enter address:");
		address=sc.next();
		address+=sc.nextLine();
		if(address=="") {
			System.out.println("address field is mandatory!");
			System.exit(0);
		}
		System.out.println("Enter roll number:");
		try {
			rollno=Integer.parseInt(sc.next());
			if(rollSet.contains(rollno)) {
				System.out.println("Enter unique roll number!");
				System.exit(0);
			} else {
				rollSet.add(rollno);
			}
		} catch(NumberFormatException e) {
			System.out.println("Enter a valid roll number!");
			System.exit(0);
		}
		System.out.println("Enter any 4 courses from the given 6 options - A,B,C,D,E,F");
		int count= 1;
		char ch;
		while(count<=4) {
			System.out.println("Enter course:");
			ch=sc.next().charAt(0);
			if(ch!='A' && ch!='B' && ch!='C' && ch!='D' && ch!='E'&&
					ch!='F') {
				System.out.println("Enter a valid course name!");
			} else {
				if(courses.contains(ch)) {
					System.out.println("Course already selected!");
				} else {
					count=count+1;
					courses.add(ch);
				}
			}
			
		}
		Student obj= new Student(name,age,address,rollno,courses);
		return obj;
	}
}
class DisplayDetails {
	public void display(ArrayList<Student> st) {
		System.out.println("Name\t\tAge\t\tRoll number\tAddress\t\t\tCourse");
		for(Student s : st) {
			System.out.println(s.getName()+"\t\t"+s.getAge()+"\t\t"+s.getRollno()+"\t\t"+s.getAddress()+"\t\t\t"+s.getCourses());
		}
	}
}
class DeleteEntry {
	public ArrayList<Student> deleteDetails(ArrayList<Student> st) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter roll number of the student whose details are to be deleted:");
		try {
			int roll=Integer.parseInt(sc.next());
			int flag=0;
			for(Student s:st) {
				if(roll==s.getRollno()) {
					st.remove(s);
					System.out.println("Entry Deleted");
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("No student with the entered roll number!");
			} 
		} catch(NumberFormatException e) {
			System.out.println("Invalid Input!");
			System.exit(0);
		}
		return st;
	}
}
class SaveToDisk {
	public void saveDetails(File fname, ArrayList<Student> st) throws IOException {
		FileOutputStream fos=null;
		ObjectOutputStream out=null;
		try {
			fos = new FileOutputStream(fname);
			out = new ObjectOutputStream(fos);
			out.writeObject(st);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			fos.close();
		}
	}
}
public class Assignment2 {
	private static final long serialVersionUID=18L;
	static File fname=new File("details.ser");
	public static ArrayList<Student> loadDetails() throws IOException,ClassNotFoundException {
		ArrayList<Student> temp = new ArrayList<Student>();
		FileInputStream file = null;
		ObjectInputStream in = null;
		//pre populating the data stored on the disk
		try {
			file = new FileInputStream(fname);
			in = new ObjectInputStream(file);
			temp = (ArrayList<Student>)in.readObject();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
			file.close();
			return temp;
		}
	}
	public static void main(String[] args) throws IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<Student> studentList=new ArrayList<Student>();
		if(fname.length()!=0) {
			studentList = loadDetails();
		}
		int choice= 0;
		while(choice!=5) {
			System.out.println("MENU \n 1. Add User Details \n 2. Display User Details \n 3. Delete User Details \n 4. Save User Details \n 5. Exit \n Enter your choice:");
			try {
				choice= Integer.parseInt(sc.next());
				if(choice<1 || choice>5) {
					System.out.println("Invalid Choice");
					continue;
				} 
			} catch(NumberFormatException e) {
				System.out.println("Invalid Choice");
				System.exit(0);
			}
			switch(choice) {
			case 1: AddDetails obj1 = new AddDetails();
			        Student st = obj1.addStudent();
			        studentList.add(st);
			        Collections.sort(studentList,new compareByName());
			        break;
			case 2:  DisplayDetails obj2=new DisplayDetails();
			         obj2.display(studentList);
			         System.out.println("Do you want to display result in sorted manner -(y/n):");
			         char  ch= sc.next().charAt(0);
			         if(ch=='y') {
			        	 ArrayList<Student> temp=new ArrayList<Student>(studentList);
			        	 System.out.println("Select field for sorting: \n 1. name \n 2. age \n 3. address \n 4. roll number");
			 			 try {
			 				int field= Integer.parseInt(sc.next());
			 				compareList cl=new compareList();
			 				cl.setField(field);
			 				//sorting the list
			 				System.out.println("Select Order\n1.Ascending 2.Descending");
			 				int order=Integer.parseInt(sc.next());
			 				if(order==1) {
			 					Collections.sort(temp,cl);
			 					obj2.display(temp);
			 				} else if(order==2) {
			 					Collections.sort(temp,cl);
			 					Collections.reverse(temp);
			 					obj2.display(temp);
			 					
			 				} else {
			 					System.out.println("Invalid order!");
			 				}
			 				
			 			 } catch(NumberFormatException e) {
			 				 System.out.println("Invalid input!");
			 			 }
			         }
			         break;
			case 3: DeleteEntry obj3 = new DeleteEntry();
			        studentList= obj3.deleteDetails(studentList);
			        break;
			case 4: SaveToDisk obj4 = new SaveToDisk();
			        obj4.saveDetails(fname, studentList);
			        break;
			case 5: System.out.println("Do you want to save the latest changes? (y/n)");
			        char save_changes= sc.next().charAt(0);
			        if(save_changes=='y') {
			        	SaveToDisk obj5 = new SaveToDisk();
			        	obj5.saveDetails(fname, studentList);
			        	System.exit(0);
			        } else if(save_changes!='n') {
			        	System.out.println("Invalid Input!");
			        }
			        System.exit(0);
			        break;
			}
		}

	}

}
