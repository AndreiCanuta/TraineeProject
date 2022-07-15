package service;

import csvThreads.ThreadHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {
    private static CustomerService customerService;
    private static ThreadHandler threadHandler;

    @BeforeAll
    static void initializing()  {
        customerService = new CustomerService();
        threadHandler = new ThreadHandler();

        threadHandler.run();
        try {
            Thread.sleep(1000);
            assertEquals(1000, customerService.getAllCustomers().size());
        } catch (InterruptedException e) {
            fail("Threads not working");
        }
    }

    @Test
    public void testTest () {
        assertEquals(1000, 1000);
    }
}
