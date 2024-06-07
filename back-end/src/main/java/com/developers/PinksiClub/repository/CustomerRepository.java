package com.developers.PinksiClub.repository;

import com.developers.PinksiClub.service.Customer;

import java.util.List;

public interface CustomerRepository {
   Customer save(Customer customer);
   Customer findById(int id);

    Customer findById(Long id);

    List<Customer> findAll();
    void delete(Long id);
}
