package com.example.desiner.Controller;

import com.example.desiner.DTO.RateDTO;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.RateOrder;
import com.example.desiner.Service.RateOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/rate")
@RequiredArgsConstructor
public class RateOrderController {
private final RateOrderService rateOrderService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(rateOrderService.getAll());
    }

@PostMapping("addOrder/{customerId}/{orderId}")
public ResponseEntity addOrder1(@AuthenticationPrincipal @RequestBody RateDTO dto, @PathVariable Integer customerId) {
    rateOrderService.addRateOrder(dto, customerId);
    return ResponseEntity.status(200).body("Rating Add");
}
}
