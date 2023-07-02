package org.example.service.impl;

import org.example.payload.CustomerDto;
import org.example.entity.Customer;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        Customer customer = getCustomerByIdFromRepository(customerId);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer createdCustomer = customerRepository.save(customer);
        return modelMapper.map(createdCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(Integer customerId, CustomerDto customerDto) {
        getCustomerByIdFromRepository(customerId);
        Customer updatedCustomer = modelMapper.map(customerDto, Customer.class);
        updatedCustomer.setId(customerId);
        Customer savedCustomer = customerRepository.save(updatedCustomer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Customer customer = getCustomerByIdFromRepository(customerId);
        customerRepository.delete(customer);
    }

    private Customer getCustomerByIdFromRepository(Integer customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
    }
}
