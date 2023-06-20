package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.Order;
import com.example.desiner.Model.Services;
import com.example.desiner.Repository.CustomerRepository;
import com.example.desiner.Repository.DesignerRepository;
import com.example.desiner.Repository.OrderRepository;
import com.example.desiner.Repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ServicesRepository servicesRepository;
    private final DesignerRepository designerRepository;


    public List<Order> getAll(){
        return orderRepository.findAll();
    }
    //end point>>reem
    public List<Order> getOrdersByDesigner(Designer designer){
        return orderRepository.findOrdersByDesigner(designer);
    }

//endpoint add order calculate the total price ,status by default"notStarted"
//end point>>reem
public void addOrder1(Integer customerId,Order order,Integer servicesId){
    Customer customer=customerRepository.findCustomerById(customerId);
    Services services=servicesRepository.findServicesById(servicesId);
    if (customer==null||services==null)
        throw new ApiException("Invalid");
    order.setTotalPrice(services.getPrice() * order.getArea());
    order.setStatus("notStarted");  //by default
    order.setCustomer(customer);
    order.setDesigner(services.getDesigner());
    Set<Services> servicesSet = order.getServices();
    if (servicesSet == null)
        servicesSet = new HashSet<>();
    servicesSet.add(services);
    orderRepository.save(order);
}

    public void updateOrder(Integer customerId,Order order,Integer orderId){
        Customer customer=customerRepository.findCustomerById(customerId);
        Order oldorder=orderRepository.findOrderById(orderId);
        if(oldorder==null||customer==null){
            throw new ApiException("order not found");
        }
        oldorder.setId(order.getId());
        oldorder.setDescription(order.getDescription());
        oldorder.setTotalPrice(order.getTotalPrice());
        oldorder.setStatus(order.getStatus());
        oldorder.setArea(order.getArea());
        orderRepository.save(oldorder);
    }
    //endpoint check order status if in progress or done
    //regayah
    public void deleteOrder(Integer customerId,Integer orderId){
        Order order=orderRepository.findOrderById(orderId);
        Customer customer=customerRepository.findCustomerById(customerId);

        if(order==null||order.getStatus().equals("inProgress")||order.getStatus().equals("Done")){
            throw new ApiException("can't deleted");
        }
        if (customer.getId() != customerId){
            throw new ApiException("Error");
        }
        orderRepository.delete(order);
    }

    //  Create endpoint that change order status(only designer can change it)
    //end point >reem
    public void changeStatus(Integer designerId,Integer orderId,String status){
        Designer designer=designerRepository.findDesignerById(designerId);
        Order order=orderRepository.findOrderById(orderId);
        if (order==null||designer==null || order.getDesigner() != designer)
            throw new ApiException("Not changed");
     //   if (order.getStatus().equalsIgnoreCase("notStarted")|| order.getStatus().equalsIgnoreCase("inProgress") || order.getStatus().equalsIgnoreCase("Done"))
            order.setStatus(status);
//        else
//            throw new ApiException("UnAuthorized");
     order.setDesigner(designer);
        orderRepository.save(order);
    }

    // endpoint  that get order by Status
    //regayah

    public  Order getOrderByStatus(String status){
        Order order=orderRepository.findOrderByStatus(status);
        if (order==null){
            throw new ApiException("not found");
        }
        return order;
    }

//Get all customer orders
//end point>>reem
public List<Order> getAllCustomer() {
    List<Order> orders = orderRepository.findAll();
    return orders;
}

    public List<Order> findOrderByArea() {
        List<Order> orderList = orderRepository.findOrderByArea(findOrderByArea().size());
        return orderList;
    }














//    public void assignCustomerToOrder(Integer orderId,Integer customerId){
//        Order order=orderRepository.findOrderById(orderId);
//        Customer customer=customerRepository.findCustomerById(customerId);
//        if (order==null||customer==null){
//            throw new ApiException("Data Wrong");
//        }
//        order.setCustomer(customer);
//        orderRepository.save(order);
//    }
//    public void assignOrderToDesigner( Integer orderId,Integer designerId){
//        Order order=orderRepository.findOrderById(orderId);
//        D
//        if (order==null||customer==null){
//            throw new ApiException("Id Wrong");
//        }
//        customer.getOrders().add(order);
//        customerRepository.save(customer);
//       orderRepository.save(order);
//    }
}
