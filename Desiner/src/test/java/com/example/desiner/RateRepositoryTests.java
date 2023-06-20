package com.example.desiner;

import com.example.desiner.Model.Customer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Order;
import com.example.desiner.Model.RateOrder;
import com.example.desiner.Repository.OrderRepository;
import com.example.desiner.Repository.RateOrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RateRepositoryTests {
    @Autowired
    RateOrderRepository rateOrderRepository;

    RateOrder rateOrder1;
    MyUser myUser;
    Customer customer1;
    @BeforeEach
    void SetUp(){

        customer1=new Customer  (null,"reem1","r12","12345","reem@123","CUSTOMER",myUser,null);
        rateOrder1=new RateOrder(null,5,null,null);
    }
@Test
public void  findRateOrderById(){
        rateOrderRepository.save(rateOrder1);
        RateOrder rateOrder=rateOrderRepository.findRateOrderById(myUser.getId());
        Assertions.assertThat(rateOrder).isEqualTo(rateOrder);
    }
}


