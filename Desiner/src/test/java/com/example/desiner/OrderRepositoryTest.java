package com.example.desiner;

import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Order;
import com.example.desiner.Repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    MyUser myUser;

    Designer designer;
    Order order1,order2,order3;
    Customer customer1;
Order order;
    List<Order>orders;
    Set<Order>orderList;

    @BeforeEach
    void SetUp(){

//        myUser=new MyUser(null,"r12","12345","CUSTOMER",null,null);
      customer1=new Customer  (null,"reem1","r12","12345","reem@123","CUSTOMER",myUser,null);
      order=new Order();
        order1=new Order(null,"Interior",20000,5,"Done",null,customer1,null,null);
        order2=new Order(null,"Interior",5000,2,"Done",null,customer1,null,null);
        order3=new Order(null,"Interior",8000,3,"Done",null,customer1,null,null);
        orders=new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orderList= new HashSet<>(orders);
        customer1.setOrders(orderList);

    }
@Test
    public void findOrderById(){
        orderRepository.save(order1);
 order2=orderRepository.findOrderById(order1.getId());
    Assertions.assertThat(orders).isEqualTo(order1);
}

    @Test
    public void findOrderByStatus(){

        orderRepository.save(order1);

        order3=orderRepository.findOrderByStatus(order1.getStatus());

        Assertions.assertThat(orders).isEqualTo(order1);
    }

    @Test
    public void findOrdersByDesigner(){

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

//        order=orderRepository.findOrdersByDesigner(order);

        Assertions.assertThat(orders.get(0).getDesigner().getId()).isEqualTo(designer.getId());
    }

    @Test
    public void findOrderByArea(){

        orderRepository.save(order2);

        List<Order>orders1=orderRepository.findOrderByArea(order1.getArea());

        Assertions.assertThat(orders1).isEqualTo(order1);
    }



}
