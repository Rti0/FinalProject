package com.example.desiner.Controller;

import com.example.desiner.Model.MyUser;
import com.example.desiner.Service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(myUserService.getAll());
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getUser(@AuthenticationPrincipal @RequestBody MyUser myUser){
        return ResponseEntity.status(200).body(myUserService.getUser(myUser.getId()));
    }

//    @PostMapping("/add")
//    public ResponseEntity addUser(@Valid @RequestBody MyUser myUser){
//        myUserService.addUser(myUser);
//        return ResponseEntity.status(200).body("Added Done");
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity updateUser(@AuthenticationPrincipal  MyUser myUser, @PathVariable Integer id){
//    myUserService.updateUser(myUser,id);
//    return ResponseEntity.status(200).body("Updated Done");
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteUser(@AuthenticationPrincipal @PathVariable Integer id){
//        myUserService.deleteUser(id);
//        return ResponseEntity.status(200).body("Deleted Done");
//    }
//    @PostMapping("/registerCustomer")
//    public ResponseEntity register( @RequestBody MyUser myUser){
//        myUserService.register(myUser);
//        return ResponseEntity.status(200).body("User register");
//    }
//    @PostMapping("/registerDesigner")
//    public ResponseEntity registerDesigner( @RequestBody MyUser myUser){
//        myUserService.register(myUser);
//        return ResponseEntity.status(200).body("User register");
//    }
    @PostMapping("/admin")
    public ResponseEntity ADMIN() {
        return ResponseEntity.status(200).body("Welcome customer");
    }
    @PostMapping("/designer")
    public ResponseEntity designer(){
        return ResponseEntity.status(200).body("Welcome Designer");
    }

    @PostMapping("/customer")
    public ResponseEntity customer(){
        return ResponseEntity.status(200).body("Welcome customer");
    }


    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(" welcome LogIn");
    }


    @PostMapping("/logout")
    public ResponseEntity Logout(){
        return ResponseEntity.status(200).body("LogOut");
    }

}
