//package com.example.desiner;
//
//import com.example.desiner.Model.DesignerBusiness;
//import com.example.desiner.Model.MyUser;
//import com.example.desiner.Model.Order;
//import com.example.desiner.Model.Services;
//import com.example.desiner.Repository.*;
//import com.example.desiner.Service.OrderService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.*;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@ExtendWith(MockitoExtension.class)
//public class OrderServicesTest {
//
//    @InjectMocks
//    OrderService orderService;
//
//    @Mock
//    OrderRepository orderRepository;
//
//    @Mock
//    CustomerRepository customerRepository;
//    @Mock
//    ServicesRepository servicesRepository;
//
//    MyUser myUser;
//
//    Services service1,service2;
//
//    List<Services>servicesList,services;
//    Order order1,order2;
//
//    List<Order>orderList;
//    Set<Order>orderSet;
//
//
//    @BeforeEach
//    void setUp() {
//        myUser=new MyUser(1,"Maha" , "12345" , "ADMIN" ,null,null);
//        service1=new Services(null,"service1","Interior","djnfjnjdaskqqqqq",2000,null,null);
//        service2=new Services(null,"service2","Exterior","eeeeee",3500,null,null);
//        order1=new Order(null,"Exterior Design",2000,10,"Done",null,null,null,null);
//        order2=new Order(null,"Interior Design",1000,8,"Done",null,null,null,null);
//        orderList=new ArrayList<>();
//        orderList.add(order1);
//        orderList.add(order2);
//        orderSet=new HashSet<>(orderList);
//        service1.setOrders(orderSet);
//        service2.setOrders(orderSet);
//        myUser.setCustomer(myUser.getCustomer());
//        services=new ArrayList<>();
//        services.add(service1);
//        services.add(service2);
//
//    }
//
//    @Test
//    public void getAll(){
//        when(orderRepository.findAll()).thenReturn(orderSet);
//        orderList = orderService.getAll();
//        Assertions.assertEquals(servicesList,services);
//        Assertions.assertEquals(2,services.size());
//        verify(orderRepository,time(1)).findAll();
//    }
//
//    @Test
//    public void getOrdersByDesigner(){
//        when(orderRepository.findOrderById(order1.getId())).thenReturn(order1);
//        order2 = orderService.getAll(order1.getId());
//        Assertions.assertEquals(order1,order2);
//        verify(orderRepository,times(1)).findOrderById(order1.getId());
//    }
//
//
//    @Test
//    public void addOrder1(){
//        orderService.addOrder1(services,order1);
//        verify(orderRepository,times(1)).save(order1);
//    }
//
//    @Test
//    public void updateOrder(){
//        when(customerRepository.findCustomerById(myUser.getId())).thenReturn(myUser);
//        when(orderRepository.findOrderById(order1.getId())).thenReturn(order1);
//        orderService.updateOrder(myUser.getId(),order1,order1.getId());
//        verify(customerRepository,times(1)).findMyUserById(myUser.getId());
//        verify(customerRepository,times(1)).findProductById(order1.getId());
//    }
//
//    @Test
//    public void deleteOrder(){
//        when(customerRepository.findCustomerById(myUser.getId())).thenReturn(myUser);
//        when(orderRepository.findOrderById(order1.getId())).thenReturn(order1);
//        orderService.deleteOrder(myUser.getId(),order1.getId());
//        verify(customerRepository,times(1)).findMyUserById(myUser.getId());
//        verify(orderRepository,times(1)).findProductById(order1.getId());
//    }
//
//
//}
