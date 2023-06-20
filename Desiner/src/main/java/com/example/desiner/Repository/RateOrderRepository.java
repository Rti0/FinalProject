package com.example.desiner.Repository;

import com.example.desiner.Model.Designer;
import com.example.desiner.Model.RateOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateOrderRepository extends JpaRepository<RateOrder,Integer> {

    RateOrder findRateOrderById(Integer id);


}
