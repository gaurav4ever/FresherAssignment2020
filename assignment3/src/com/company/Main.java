package assignment3.src.com.company;

public class Main {

    public static void main(String[] args) {
        Boolean flag = Boolean.TRUE;
        Operations operations = new Operations();
        while(flag){
            flag = operations.menu();
        }
    }
}
