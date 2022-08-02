package com.trainee.traineeproject.service;

import com.trainee.traineeproject.entity.*;
import com.trainee.traineeproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO getCustomer(UUID id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer does not exist"));
        return CustomerDTO.builder()
                .storeNumber(customer.getStoreNumber())
                .country(customer.getCountry())
                .name(customer.getName())
                .VAT(customer.getVAT())
                .CheckoutCheckCode((customer.getCheckoutCheckCode()))
                .build();
    }

    @Transactional
    public List<CustomerDTO> getAllCustomers(){
        Iterable<Customer> customerIterable = customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        customerIterable.forEach(customers::add);

        return customers.stream()
                .map(c -> CustomerDTO.builder()
                        .storeNumber(c.getStoreNumber())
                        .country(c.getCountry())
                        .name(c.getName())
                        .VAT(c.getVAT())
                        .CheckoutCheckCode((c.getCheckoutCheckCode()))
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(UUID id) throws Exception {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new Exception("id not found");
        }
    }

    @Transactional
    public void updateStoreNumber(UUID id, String newStoreNumber ) throws Exception {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer does not exist"));
        customer.setStoreNumber(newStoreNumber);
        customerRepository.save(customer);
    }

    @Transactional
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public List<Customer> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Customer> pagedResult = customerRepository.findAll(paging);
        return pagedResult.toList();
    }

    @Transactional
    public Customer updateCustomer(UUID id, CustomerDTO customerDTO) {

        if (customerRepository.findById(id).isPresent()){
            Customer existingCustomer = customerRepository.findById(id).get();

            existingCustomer.setCustomerNumber(customerDTO.getStoreNumber());
            existingCustomer.setCustomerType(customerDTO.getCustomerType());
            existingCustomer.setCountry(customerDTO.getCountry());
            existingCustomer.setName(customerDTO.getName());
            existingCustomer.setCheckoutCheckCode(customerDTO.getCheckoutCheckCode());
            existingCustomer.setCurrentCreditData(customerDTO.getCurrentCreditData());
            existingCustomer.setVAT(customerDTO.getVAT());

            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return updatedCustomer;
        }else{
            return null;
        }
    }
}
