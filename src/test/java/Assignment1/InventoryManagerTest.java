package Assignment1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryManagerTest {

    InventoryManager inventoryManager;
    @Before
    public void setUp() throws Exception {
        inventoryManager = new InventoryManager();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void validateInput() {
        assertTrue(inventoryManager.validateInput("-name ram"));
    }
}