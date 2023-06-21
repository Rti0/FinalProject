package com.example.desiner.Controller;

import com.example.desiner.DTO.DesignerDTO;
import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Model.Order;
import com.example.desiner.Service.DesignerService;
import com.example.desiner.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/designer")
@RequiredArgsConstructor
public class DesignerController {
    private final DesignerService designerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Designer> designers=designerService.findAll();
        return ResponseEntity.status(200).body(designers);
    }

    @PostMapping("/add")
    public ResponseEntity addDesigner(@AuthenticationPrincipal @RequestBody @Valid DesignerDTO designerDTO){
        designerService.addDesigner(designerDTO);
        return ResponseEntity.status(200).body("Added Done");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDesigner(@AuthenticationPrincipal @RequestBody @Valid  Designer designer, @PathVariable Integer id){
        designerService.updateDesigner(designer, id);
        return ResponseEntity.status(200).body("Updated Done");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDesigner(@AuthenticationPrincipal @PathVariable Integer id) {
        designerService.deleteDesigner(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }

    @GetMapping("/customer-id/{customerId}")
    public ResponseEntity getCustomerById(@AuthenticationPrincipal @PathVariable Integer customerId){
        Customer c =designerService.getCustomerById(customerId);
        return ResponseEntity.status(200).body(c);
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getDesignerByName( @AuthenticationPrincipal @PathVariable String name){
        Designer designer=designerService.SearchDesignerByName(name);
        return ResponseEntity.status(200).body(designer);
    }
    @GetMapping("/get-name/{email}")
    public ResponseEntity findDesignerByEmail( @AuthenticationPrincipal @PathVariable String email){
        Designer designer=designerService.SearchDesignerByEmail(email);
        return ResponseEntity.status(200).body(designer);
    }
}
