package com.example.desiner.Repository;

import com.example.desiner.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,Integer> {

   MyUser findMyUserById(Integer id);

   MyUser findMyUserByUsername(String username);


}