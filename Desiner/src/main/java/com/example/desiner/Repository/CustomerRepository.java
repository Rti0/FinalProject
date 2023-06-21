package com.example.desiner.Repository;

import com.example.desiner.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);


    Customer findCustomerByName(String name);
}
