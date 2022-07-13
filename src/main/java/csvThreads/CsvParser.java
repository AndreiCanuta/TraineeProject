package csvThreads;

import entity.*;

import java.time.LocalDate;
import java.util.Date;

public class CsvParser {

    public Customer lineToCustomer (String line) {
        String[] split = line.split(",");
        String country = split[0];
        String storeNumber = split[1];
        String customerNumber = split[2];
        CustomerId customerId = new CustomerId(storeNumber, customerNumber, country);

        String name = split[3];
        String VAT = split[4];
        String checkoutCheckCode = split[5];

        double limit = Double.parseDouble(split[6]);
        Product product = Product.valueOf(split[7]);
        int period = Integer.parseInt(split[8]);
        CreditData creditData = new CreditData(limit, product, period);

        CustomerType customerType = CustomerType.valueOf(split[9]);
        LocalDate date = LocalDate.parse(split[10]);

        return new Customer(customerId, name, VAT, checkoutCheckCode, creditData, customerType, date);
    }

}
