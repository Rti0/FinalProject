package com.example.desiner;

import com.example.desiner.ApiResponse.ApiResponse;
import com.example.desiner.Controller.OrderController;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Order;
import com.example.desiner.Service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.delete;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = OrderController.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class OrderControllerTests {
    @MockBean
    OrderService orderService;

    @Autowired
    MockMvc mockMvc;

    Order order1,order2,order3;
    MyUser myUser;

    ApiResponse apiResponse;

    List<Order> orders,orderList;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(1,"Maha" , "12345" , "ADMIN" ,null,null);
        order1=new Order(null,"Exterior Design",2000,10,"Done",null,null,null,null);
        order1=new Order(null,"Interior Design",1000,8,"Done",null,null,null,null);

        orders= Arrays.asList(order1);
        orderList=Arrays.asList(order2);
    }
    @Test
    public void getAllOrder() throws Exception {
       Mockito.when(orderService.getAll()).thenReturn(orders);
        mockMvc.perform(get("/api/v1/order/get"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("order1"));
    }



//    @Test
//    public void testAddOrder1() throws  Exception {
//        mockMvc.perform(post("/api/v1/order/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(new ObjectMapper().writeValueAsString(order2)))
//                .andExpect(status().isOk());
//
//    }

//    @Test
//    public void testDeleteOrder() throws Exception{
//        mockMvc.perform(delete("/api/v1/order/{orderId}",order1.getId()))
//                .andExpect(status().isOk());
//    }

}
