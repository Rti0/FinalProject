package com.example.desiner.Controller;

import com.example.desiner.ApiResponse.ApiResponse;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.DesignerBusiness;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Service.DesignerBusinessService;
import com.example.desiner.Service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/DB")
@RequiredArgsConstructor
public class DesignerBusinessController {

    private final DesignerBusinessService designerBusinessService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<DesignerBusiness>designerBusinesses=designerBusinessService.findAll();
        return ResponseEntity.status(200).body(designerBusinesses);
    }

    @PostMapping("/add")
    public ResponseEntity addDB(@AuthenticationPrincipal MyUser myUser, @RequestBody DesignerBusiness designerBusiness){
        designerBusinessService.addDB(myUser.getId(), designerBusiness);
        return ResponseEntity.status(200).body(new ApiResponse("designerBusiness added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDB(@AuthenticationPrincipal MyUser myUser,@RequestBody DesignerBusiness designerBusiness, @PathVariable Integer id){
        designerBusinessService.updateDB(designerBusiness, id);
        return ResponseEntity.status(200).body("designer Business Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDB(@AuthenticationPrincipal Designer designer ,@PathVariable Integer id){
        designerBusinessService.deleteDB(id);
        return ResponseEntity.status(200).body("designer Business deleted");

    }

}
