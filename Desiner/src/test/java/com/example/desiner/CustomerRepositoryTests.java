package com.example.desiner;

import com.example.desiner.Model.Customer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Repository.CustomerRepository;
import com.example.desiner.Repository.MyUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTests {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MyUserRepository myUserRepository;


    Customer c1,c2,c3;

    List<Customer>customers;

    MyUser myUser;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Reem" , "12345" , "CUSTOMER",null,null);
        c1 = new Customer(null , "Reem","rrr@12 ","riyadh",myUser,null);
        c2 = new Customer(null , "Rahaf","rrr@14 ","riyadh",myUser,null);
        c3 = new Customer(null , "Amal","rrr@13 ","riyadh",myUser,null);
    }
    @Test
    public void findAllByMyUserTesting(){
        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        List<Customer> customers1= customerRepository.findAllByMyUser(myUser);
        Assertions.assertThat(customers1.get(0).getMyUser().getId()).isEqualTo(myUser.getId());
    }

    @Test
    public void findCustomerById(){
        customerRepository.save(c1);
        Customer customer=customerRepository.findCustomerById(c1.getId());
        Assertions.assertThat(customer).isEqualTo(c1);
    }

    @Test
    public void findCustomerByName(){
        customerRepository.save(c1);
        Customer customer=customerRepository.findCustomerByName(c1.getName());
        Assertions.assertThat(customer).isEqualTo(c1);
    }

}
