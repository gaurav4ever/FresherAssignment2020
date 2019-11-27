package assignment1;

import assignment1.exceptions.InvalidCommandLineArgument;
import assignment1.models.Item;
import assignment1.models.ItemDetail;
import assignment1.models.RawItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineParserTest {

    @Test
    void parse() {
        String [] args = new String[]{"-name" , "natesh" , "-type" , "raw" , "-price" , "10.100" , "-quantity" , "10"} ;
        ItemDetail itemDetail ;
        CommandLineParser parser = new CommandLineParser();

        itemDetail = parser.getItemDetail(args) ;
        Item item = itemDetail.getItem() ;

        assertNotNull(item) ;
        assertNotNull(item.getName()) ;
        assertEquals(item.getClass() , RawItem.class );
        assertNotNull(item.getPrice()) ;
        assertEquals(item.getPrice(), 10.100) ;
        assertEquals(item.getName() , "natesh") ;
        assertEquals(itemDetail.getQuantity(), 10) ;

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-type" , "raw" , "-name" , "natesh"} ;
            new CommandLineParser().getItemDetail(temp) ;
        });

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-name" , "natesh" , "-type" , "-price"} ;
            new CommandLineParser().getItemDetail(temp) ;
        });

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-name" , "natesh" , "-type" , "junk"} ;
            new CommandLineParser().getItemDetail(temp) ;
        });

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-name" , "natesh"  , "-quantity" , "10.43" , "-type" , "raw"} ;
            new CommandLineParser().getItemDetail(temp) ;
        });
    }
}