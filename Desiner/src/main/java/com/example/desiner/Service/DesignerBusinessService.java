package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.DesignerBusiness;
import com.example.desiner.Repository.DesignerBusinessRepository;
import com.example.desiner.Repository.DesignerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignerBusinessService {

    private final DesignerBusinessRepository designerBusinessRepository;
    private final DesignerRepository designerRepository;

    public List<DesignerBusiness>findAll(){
        return designerBusinessRepository.findAll();
    }

    public void addDB(Integer designerId,DesignerBusiness designerBusiness){
    Designer designer=designerRepository.findDesignerById(designerId);

    if (designer==null){
        throw new RuntimeException("Invalid");
    }
        designerBusiness.setId(null);
        designerBusiness.setDesigner(designer);
        designer.getDesignerBusinesses().add(designerBusiness);
        designerBusinessRepository.save(designerBusiness);
    }
    public void updateDB(DesignerBusiness designerBusiness,Integer id){
        DesignerBusiness oldDB=designerBusinessRepository.findDesignerBusinessById(id);

        if (oldDB==null)
            throw new ApiException("not found");

        oldDB.setDesigner(designerBusiness.getDesigner());
        oldDB.setAchievement(designerBusiness.getAchievement());
        oldDB.setImage(designerBusiness.getImage());
        oldDB.setBody(designerBusiness.getBody());
        designerBusinessRepository.save(oldDB);
    }

    public void deleteDB(Integer id){
        DesignerBusiness d=designerBusinessRepository.findDesignerBusinessById(id);
        if(d==null)
            throw new ApiException("not found");
        designerBusinessRepository.delete(d);
    }
//    public void deleteDB(Integer designerId, Integer id){
//        DesignerBusiness DB=designerBusinessRepository.findDesignerBusinessById(id);
//        Designer designer=designerRepository.findDesignerById(designerId);
//
//        if(DB==null || designer==null || designerId != DB.getDesigner().getId()){
//            throw new ApiException("designerBusiness not found");
//        }
//        designerBusinessRepository.delete(DB);
//    }


}
