package assignment1;

import assignment1.exceptions.InvalidCommandLineArgument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class CommandLineParserTest {

    @Test
    void parse() {
        String [] args = new String[]{"-name" , "natesh" , "-type" , "raw" , "-price" , "10.100" , "-quantity" , "10"} ;
        ItemDetail itemDetail ;

        itemDetail = CommandLineParser.parse(args) ;
        Item item = itemDetail.item ;

        assertNotNull(item) ;
        assertNotNull(item.getName()) ;
        assertEquals(item.getClass() , RawItem.class );
        assertNotNull(item.getPrice()) ;
        assertEquals(item.getPrice(), 10.100) ;
        assertEquals(item.getName() , "natesh") ;
        assertEquals(itemDetail.quantity , 10) ;

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-type" , "raw" , "-name" , "natesh"} ;
            CommandLineParser.parse(temp) ;
        });

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-name" , "natesh" , "-type" , "-price"} ;
            CommandLineParser.parse(temp) ;
        });

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-name" , "natesh" , "-type" , "junk"} ;
            CommandLineParser.parse(temp) ;
        });

        assertThrows(InvalidCommandLineArgument.class , ()->{
            String[] temp = new String[]{"-name" , "natesh"  , "-quantity" , "10.43" , "-type" , "raw"} ;
            CommandLineParser.parse(temp) ;
        });
    }
}