package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.DTO.DesignerDTO;
import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Services;
import com.example.desiner.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignerService {
    private final DesignerRepository designerRepository;
    private final MyUserRepository myUserRepository;
    private final CustomerRepository customerRepository;

    public List<Designer> findAll() {
        return designerRepository.findAll();
    }


    public void addDesigner(DesignerDTO dto){
        MyUser myUser =new MyUser(null,dto.getUsername(), dto.getPassword(), "DESIGNER",null,null);
        String hash=new BCryptPasswordEncoder().encode(dto.getPassword());
        myUser.setPassword(hash);
        myUserRepository.save(myUser);


        Designer designer=new Designer(null, dto.getName(), dto.getUsername(), dto.getPassword(), dto.getEmail(), dto.getLocation(),null,null, myUser,null,null);
        designerRepository.save(designer);
    }

    public void updateDesigner(Designer designer,Integer id){
        Designer designer1=designerRepository.findDesignerById(id);
        if (designer1==null){
            throw new ApiException("Not Found");
        }
        designer1.setId(designer.getId());
        designer1.setName(designer.getName());
        designer1.setEmail(designer.getEmail());
        designer1.setLocation(designer.getLocation());
        designerRepository.save(designer1);
    }

    public void deleteDesigner(Integer id){
        Designer designer=designerRepository.findDesignerById(id);
        if (designer==null){
            throw new ApiException("Not Found");
        }
        designerRepository.delete(designer);
    }
    // >>reem
    public Customer getCustomerById(Integer id) {
        Customer customer=customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("Not found");
        }
        return customer;
    }


    //endpoint Search designer by name>>reem
    public Designer SearchDesignerByName(String name){
        Designer designer= designerRepository.findDesignerByName(name);
        if (designer==null){
            throw new ApiException("Not Found");
        }
        return designer;
    }
    //endpoint Search designer by Email>>reem
    public Designer SearchDesignerByEmail(String email){
        Designer designer= designerRepository.findDesignerByEmail(email);
        if (designer==null){
            throw new ApiException("Not Found");
        }
        return designer;
    }

}
