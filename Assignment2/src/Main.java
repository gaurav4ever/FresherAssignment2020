import util.Utility;

public class Main {
    public static void main(String[] args)
{
    final int choice = Utility.getInputItemChoice(); // menu for selecting options
    Utility.performAction(choice); // perform task according to the option chosen
}
}