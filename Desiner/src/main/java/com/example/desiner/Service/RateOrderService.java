package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.DTO.RateDTO;
import com.example.desiner.Model.*;
import com.example.desiner.Repository.CustomerRepository;
import com.example.desiner.Repository.DesignerRepository;
import com.example.desiner.Repository.OrderRepository;
import com.example.desiner.Repository.RateOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RateOrderService {

    private final RateOrderRepository rateOrderRepository;
    private final OrderRepository orderRepository;
    private final DesignerRepository designerRepository;

    public List<RateOrder> getAll(){
        return rateOrderRepository.findAll();
    }
//Reem
public void addRateOrder (RateDTO dto,Integer customerId ){
    Order order=orderRepository.findOrderById(dto.getOrderId());
    Designer d=designerRepository.findDesignerById(order.getDesigner().getId());
    if (d==null){
        throw new ApiException("can't add rate , Designer Not found");
    }
    if (order==null){
        throw new ApiException("can't add rate , order Not found");
    }
    if (order.getCustomer().getId()!=customerId)
        throw new ApiException("can't add rate");
    RateOrder rateOrder=new RateOrder(null,dto.getRating(),order,d);
    rateOrderRepository.save(rateOrder);
    d.getRateOrders().add(rateOrder);
    designerRepository.save(d);
}





}
