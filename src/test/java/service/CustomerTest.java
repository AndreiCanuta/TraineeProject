package service;

import controller.CustomerController;
import csvThreads.ThreadHandler;
import entity.CustomerId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private static CustomerService customerService;
    private static CustomerController customerController;
    private static ThreadHandler threadHandler;

    @BeforeAll
    static void initializing()  {
        customerController = new CustomerController();
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
    public void testGetByCustomerIdSuccessful () {
        CustomerId customerId = new CustomerId("2", "6546", "IT");
        assertNotNull(customerController.getByCustomerId(customerId));
    }

    @Test
    public void testGetByCustomerIdFail () {
        CustomerId customerId = new CustomerId("1", "6546", "IT");
        assertNull(customerController.getByCustomerId(customerId));
    }
}
