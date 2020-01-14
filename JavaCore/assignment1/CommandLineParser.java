package assignment1;

import assignment1.exceptions.InvalidCommandLineArgument;
import assignment1.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

// Used to parse the commandline arguments
public class CommandLineParser {

    private  void validateNumberOfArguments(ArrayList<String> args) {
        if (args.size() < 4)
            throw new InvalidCommandLineArgument("At least 4 commandline arguments needed and -name and -type options are must.");
    }

    private  void validateCompulsoryArguments(ArrayList<String> args) {
//         -name should be the first arg and -type option must be present
        if (args.indexOf("-" + Constants.NAME) != 0)
            throw new InvalidCommandLineArgument("-name option must be the first option !");
        if (args.indexOf("-" + Constants.TYPE) < 0) throw new InvalidCommandLineArgument("-type option is compulsory !");
    }

    private  void validateEachOptionHasAValue(ArrayList<String> args) {
//        An option should have a corresponding value as its next argument
        for (Iterator<String> s = args.iterator(); s.hasNext(); ) {
            if (s.next().startsWith("-") && (s.hasNext() && s.next().startsWith("-"))) {
                throw new InvalidCommandLineArgument("The value for options must not start with a dash '-' ");
            }
        }
    }

    private  void validateTypeOption(ArrayList<String> args) {
//        allow only some values for type
        String type = args.get(args.indexOf("-" + Constants.TYPE) + 1);
        switch (type) {
            case "raw":
            case "manufactured":
            case "imported":
                break;
            default:
                throw new InvalidCommandLineArgument("Invalid 'Item Type' specified !");
        }
    }

    private  void validateOptionHasCorrectDataType(ArrayList<String> args) {
        try {
            if (args.indexOf("-" + Constants.QUANTITY) >= 0)
                Integer.parseInt(args.get(args.indexOf("-" + Constants.QUANTITY) + 1));
            if (args.indexOf("-" + Constants.PRICE) >= 0)
                Double.parseDouble(args.get(args.indexOf("-" + Constants.PRICE) + 1));
        } catch (NumberFormatException e) {
            throw new InvalidCommandLineArgument("Invalid input ! Make sure that item quantity is integer and price is a number.");
        }
    }
    private  void validate(ArrayList<String> args) throws InvalidCommandLineArgument {
        validateNumberOfArguments(args);
        validateCompulsoryArguments(args);
        validateEachOptionHasAValue(args);
        validateTypeOption(args);
        validateOptionHasCorrectDataType(args);
    }


    // Returns an ItemDetail based on the arguments given here after validating their values
    public ItemDetail getItemDetail(String[] commandLineArgs) throws InvalidCommandLineArgument {
        ArrayList<String> argsList = new ArrayList<>(Arrays.asList(commandLineArgs));

        validate(argsList);

        String type = argsList.get(argsList.indexOf("-" + Constants.TYPE) + 1);
        String name = argsList.get(argsList.indexOf("-" + Constants.NAME) + 1);
        Double price = null;
        Integer quantity = null;

        if (argsList.indexOf("-" + Constants.PRICE) >= 0) {
            price = Double.parseDouble(argsList.get(argsList.indexOf("-" + Constants.PRICE) + 1));
        }
        if (argsList.indexOf("-" + Constants.QUANTITY) >= 0) {
            quantity = Integer.parseInt(argsList.get(argsList.indexOf("-" + Constants.QUANTITY) + 1));
        }
        if (quantity == null) quantity = 1; //default quantity

         return new ItemDetail(ItemFactory.getItem(name , type , price) , quantity) ;
    }
}
