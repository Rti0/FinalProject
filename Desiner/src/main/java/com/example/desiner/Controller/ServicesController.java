package com.example.desiner.Controller;

import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Services;
import com.example.desiner.Service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/services")
@RequiredArgsConstructor
public class ServicesController {

    private final ServicesService servicesService;

    @GetMapping("/get")
    public ResponseEntity getAllServices(){
        List<Services>services=  servicesService.getAllServices();
        return ResponseEntity.status(200).body(services);
    }

    @PostMapping("/add")
    public ResponseEntity addServices( @AuthenticationPrincipal MyUser myUser, @RequestBody Services services){
        servicesService.addServices(myUser.getId(), services);
        return ResponseEntity.status(200).body("Done added");
    }
    @PutMapping("/update/{servicesId}")
    public ResponseEntity updateServices(@AuthenticationPrincipal MyUser myUser, @RequestBody Services services,@PathVariable Integer servicesId){
        servicesService.updateServices(myUser.getId(),services,servicesId);
        return ResponseEntity.status(200).body("Done updated");
    }

    @DeleteMapping("/delete/{servicesId}")
    public ResponseEntity deleteServices(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer servicesId){
        servicesService.deleteServices(myUser.getId(),servicesId);
        return ResponseEntity.status(200).body("Done deleted");
    }

    @PutMapping("/assign/{servicesId}/{designerId}")
    public ResponseEntity assignServicesToDesigner(@AuthenticationPrincipal @PathVariable Integer servicesId, @PathVariable Integer designerId){
        servicesService.assignServicesToDesigner(servicesId, designerId);
        return ResponseEntity.status(200).body("Done Assign");
    }

    @GetMapping("/services-id/{id}")
    public ResponseEntity getServicesById(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer id){
        Services services=servicesService.getServicesById(id);
        return ResponseEntity.status(200).body(services);
    }

}
