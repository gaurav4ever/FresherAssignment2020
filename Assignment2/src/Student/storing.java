package Student;

import java.util.*;
public class storing {
    static Scanner sc=new Scanner(System.in);
    /*Comparator for sorting the list by Student Name*/
    public Comparator<student> StuName = new Comparator<student>() {

        public int compare(student s1, student s2) {
            functionality f=new functionality();
            System.out.println("Choose the type of sorting order.");
            System.out.println("1.Ascending order");
            System.out.println("2.Descending order");
            int option=sc.nextInt();
            String StudentName1 = s1.getName().toUpperCase();
            String StudentName2 = s2.getName().toUpperCase();
            if(StudentName1.equals(StudentName2))
            {
                int StudentRoll1 = s1.getRollNo();
                int StudentRoll2 = s2.getRollNo();

                return StudentRoll1-StudentRoll2;
            }

            if(option==1)
                return StudentName1.compareTo(StudentName2);
            else
                return StudentName2.compareTo(StudentName1);


        }};

    /*Comparator for sorting the list by roll no*/
    public Comparator<student> StuRollno = new Comparator<student>() {

        public int compare(student s1, student s2) {
            System.out.println("Choose the type of sorting order.");
            System.out.println("1.Ascending order");
            System.out.println("2.Descending order");
            int option=sc.nextInt();
            int rollno1 = s1.getRollNo();
            int rollno2 = s2.getRollNo();
            if(option==1)
                return rollno1-rollno2;
            else
                return rollno2-rollno1;
        }};

    public Comparator<student> StuAge = new Comparator<student>() {

        public int compare(student s1, student s2) {
            System.out.println("Choose the type of sorting order.");
            System.out.println("1.Ascending order");
            System.out.println("2.Descending order");
            int option=sc.nextInt();
            int age1 = s1.getAge();
            int age2 = s2.getAge();
            if(option==1)
                return age1-age2;
            else
                return age2-age1;
        }};

    public Comparator<student> StuAddress = new Comparator<student>() {

        public int compare(student s1, student s2) {
            System.out.println("Choose the type of sorting order.");
            System.out.println("1.Ascending order");
            System.out.println("2.Descending order");
            int option=sc.nextInt();
            String address1 = s1.getAddress().toUpperCase();
            String address2 = s2.getAddress().toUpperCase();
            if(option==1)
                return address1.compareTo(address2);
            else
                return address2.compareTo(address1);

        }};
}
