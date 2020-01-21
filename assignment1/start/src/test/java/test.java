import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class test {

    @Before
    public void setUp() throws Exception {
        System.out.println("Starting New Test *******************************************************");
    }

    @After
    public void teardown() throws Exception{
        System.out.println("Ending *******************************************************");
    }
    void init(){

    }

    @Test
    @DisplayName("RAW Test")
    public void test_first(){

    }

    @Test
    @DisplayName("Manufactured Test")
    public void test_second(){

    }

    @Test
    @DisplayName("Imported Test")
    public void test_third(){

    }
}
