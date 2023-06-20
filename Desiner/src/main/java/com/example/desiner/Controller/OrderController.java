package com.example.desiner.Controller;

import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Order;
import com.example.desiner.Service.MyUserService;
import com.example.desiner.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MyUserService myUserService;

    @GetMapping("/get")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(orderService.getAll());
    }

    @GetMapping("/get-designer")
    public ResponseEntity getOrdersByDesigner(@AuthenticationPrincipal Designer designer){
        return ResponseEntity.status(200).body(orderService.getOrdersByDesigner(designer));
    }

    @PostMapping("/addOrder/{servicesId}")
    public ResponseEntity addOrder1(@AuthenticationPrincipal MyUser myUser, @RequestBody Order order, @PathVariable Integer servicesId) {
        orderService.addOrder1(myUser.getId(), order, servicesId);
        return ResponseEntity.status(200).body("order Add");
    }

        @PutMapping("/update/{orderId}")
    public ResponseEntity updateOrder(@AuthenticationPrincipal MyUser myUser,@Valid @RequestBody Order order,@PathVariable Integer orderId) {
        orderService.updateOrder(myUser.getId(),order,orderId);
        return ResponseEntity.status(200).body("order updated");
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity deleteOrder(@AuthenticationPrincipal  MyUser myUser, @PathVariable Integer orderId ) {
        orderService.deleteOrder(myUser.getId(), orderId);
        return ResponseEntity.status(200).body("order deleted");
    }

    //endpoint

    @PutMapping("/status/{orderId}/{status}")
    public ResponseEntity changeStatus(@AuthenticationPrincipal Integer designerId , @PathVariable Integer orderId, @PathVariable String status) {
        orderService.changeStatus(designerId, orderId, status);
        return ResponseEntity.status(200).body("Status Changed");
    }

    @GetMapping("/get-status/{orderId}")
    public ResponseEntity getOrderByStatus(@AuthenticationPrincipal String status ,@PathVariable Integer orderId) {
      Order order=  orderService.getOrderByStatus(status);
        return ResponseEntity.status(200).body(order);
    }

    @GetMapping("/get-customers")
    public ResponseEntity findAllCustomer() {
        List<Order> orders = orderService.getAllCustomer();
        return ResponseEntity.status(200).body(orders);
    }
    @GetMapping("/get-area")
    public ResponseEntity findOrderByArea(){
        List<Order>orders=orderService.findOrderByArea();
        return ResponseEntity.status(200).body("area:");
    }

}
