package com.example.desiner;

import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Repository.CustomerRepository;
import com.example.desiner.Repository.DesignerRepository;
import com.example.desiner.Repository.MyUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DesignerRepositoryTests {
    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    MyUserRepository myUserRepository;


    Designer d1,d2,d3;

    List<Designer> designers;

    MyUser myUser;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Reem" , "12345" , "CUSTOMER",null,null);

    }

}
