package org.example.service;

import org.example.payload.CustomerDto;

import java.util.List;

/**
 * Service interface for managing customers.
 */
public interface CustomerService {

    /**
     * Retrieves all customers.
     *
     * @return List of customer DTOs
     */
    List<CustomerDto> getAllCustomers();

    /**
     * Retrieves a customer by its ID.
     *
     * @param customerId ID of the customer
     * @return Customer DTO
     */
    CustomerDto getCustomerById(Integer customerId);

    /**
     * Creates a new customer.
     *
     * @param customerDto Customer DTO
     * @return Created customer DTO
     */
    CustomerDto createCustomer(CustomerDto customerDto);

    /**
     * Updates an existing customer.
     *
     * @param customerId  ID of the customer to be updated
     * @param customerDto Updated customer DTO
     * @return Updated customer DTO
     */
    CustomerDto updateCustomer(Integer customerId, CustomerDto customerDto);

    /**
     * Deletes a customer by its ID.
     *
     * @param customerId ID of the customer to be deleted
     */
    void deleteCustomer(Integer customerId);
}
