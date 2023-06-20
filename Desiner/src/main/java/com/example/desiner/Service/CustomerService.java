package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.DTO.CustomerDTO;
import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Order;
import com.example.desiner.Repository.CustomerRepository;
import com.example.desiner.Repository.MyUserRepository;
import com.example.desiner.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MyUserRepository myUserRepository;
    private final OrderRepository orderRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public void addCustomer(CustomerDTO dto){
        String hash=new BCryptPasswordEncoder().encode(dto.getPassword());


        MyUser myUser =new MyUser(null,dto.getUsername(),hash,"CUSTOMER",null,null);
        Customer customer=new Customer(null, dto.getName(), dto.getUsername(), hash, dto.getEmail(),  dto.getLocation(),myUser,null);
        myUser.setCustomer(customer);
        myUserRepository.save(myUser);
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer,Integer id){
        Customer c1=customerRepository.findCustomerById(id);
        if (c1==null){
            throw new ApiException("Not Found");
        }
        c1.setId(customer.getId());
        c1.setName(customer.getName());
        c1.setEmail(customer.getEmail());
        c1.setLocation(customer.getLocation());
        customerRepository.save(c1);
    }

    public void deleteCustomer(Integer id){
        Customer customer=customerRepository.findCustomerById(id);
        if (customer==null) {
            throw new ApiException("Not Found");
        }
        customerRepository.delete(customer);
}


    //>>reem
    public Customer getById(Integer id){
        Customer customer=customerRepository.findCustomerById(id);
        if (customer==null){
            throw new ApiException("Not Found");
        }
        return customer;
    }
    //endpoint Search customer by name>>reem
    public Customer SearchCustomerByName(String name){
       Customer customer=customerRepository.findCustomerByName(name);
        if (customer==null){
            throw new ApiException("Not Found");
        }
        return customer;
    }

}
