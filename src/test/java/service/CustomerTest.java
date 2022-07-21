package service;

import csvThreads.ThreadHandler;
import com.trainee.traineeproject.entity.Customer;
import com.trainee.traineeproject.entity.CustomerId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.PropertyReaderUtil;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private static CustomerService customerService;
    private static CustomerController customerController;
    private static ThreadHandler threadHandler;

    @BeforeAll
    static void initializing()  {
        PropertyReaderUtil.readAppProperty();
        customerController = new CustomerController();
        customerService = new CustomerService();
        threadHandler = new ThreadHandler();

//        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        threadHandler.run();
//        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        assertEquals(1000000, customerService.getAllCustomers().size());
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

    @Test
    public void testGetGroupByVATSuccessful () {
        String VAT = new String("RO-000-2");
        assertNotNull(customerController.getGroupByVAT(VAT));
    }

    @Test
    public void testGetGroupByVATUnsuccessful () {
        String VAT = new String("RO-000-17");
        assertEquals(customerController.getGroupByVAT(VAT).size(), 0);
    }

    @Test
    public void testChangeCheckOutCode () {
        customerController.changeCheckoutCode("DE", "30", "32");
        CustomerId customerId = new CustomerId("1", "9830", "DE");
        Customer customer = customerController.getByCustomerId(customerId);
        assertEquals(customer.getCheckoutCheckCode(), "32");
    }
}
