package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MyUserService {
private final MyUserRepository myUserRepository;


    public List<MyUser> getAll(){
        return myUserRepository.findAll();
    }

    public MyUser getUser(Integer id){
        return myUserRepository.findMyUserById(id);
    }

//    public void register(MyUser myUser){
//        String hash=new BCryptPasswordEncoder().encode(myUser.getPassword());
//        myUser.setPassword(hash);
////        myUser.setRole("CUSTOMER");
//        myUserRepository.save(myUser);
//    }

//public void addUser(MyUser myUser){
//      myUserRepository.save(myUser);
//}
//
//public void updateUser(MyUser myUser,Integer id) {
//    MyUser old = myUserRepository.findMyUserById(id);
//    if (old == null) {
//        throw new ApiException("there is no user to update");
//    }
//    old.setId(myUser.getId());
//    old.setUsername(myUser.getUsername());
//    old.setPassword(myUser.getPassword());
//    old.setRole(myUser.getRole());
//    myUserRepository.save(old);
//}
//public void deleteUser(Integer id){
//      MyUser user1=myUserRepository.findMyUserById(id);
//      if (user1==null){
//          throw new ApiException("there is no user to delete");
//      }
//      myUserRepository.delete(user1);
//  }

////    public void registerDesigner(MyUser myUser){
//        String hash=new BCryptPasswordEncoder().encode(myUser.getPassword());
//        myUser.setRole(hash);
//        myUser.setRole("DESIGNER");
//        myUserRepository.save(myUser);
//    }

}
