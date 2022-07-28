package com.trainee.traineeproject.utils;

import com.trainee.traineeproject.entity.*;

import java.time.LocalDate;

public class CsvParser {

    public static Customer lineToCustomer (String line) {
        String[] split = line.split(",");
        String country = split[0];
        String storeNumber = split[1];
        String customerNumber = split[2];

        String name = split[3];
        String VAT = split[4];
        String checkoutCheckCode = split[5];

        Integer limit = Integer.parseInt(split[6]);
        Product product = Product.valueOf(split[7]);
        Integer period = Integer.parseInt(split[8]);
        CreditData creditData = new CreditData(limit, product, period, CreditDataType.CURRENT);

        CustomerType customerType = CustomerType.valueOf(split[9]);
        LocalDate date = LocalDate.parse(split[10]);

        return new Customer(storeNumber,customerNumber,country, name, VAT, checkoutCheckCode, creditData, customerType, date);
    }

}
