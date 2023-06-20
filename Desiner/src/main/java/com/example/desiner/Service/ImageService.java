package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.DTO.ImageDTO;
import com.example.desiner.Model.DesignerBusiness;
import com.example.desiner.Model.Image;
import com.example.desiner.Repository.DesignerBusinessRepository;
import com.example.desiner.Repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
private final DesignerBusinessRepository designerBusinessRepository;


    public List<Image> getAll(){
        return imageRepository.findAll();
    }
    public void addImago(ImageDTO dto){
        DesignerBusiness DB=designerBusinessRepository.findDesignerBusinessById(dto.getDesignerBusinessId());
        if(DB==null){
            throw new ApiException("can't add designer");
        }
       Image image=new Image(null,dto.getUrl(),DB);
       imageRepository.save(image);
    }
    public void updateImage(Integer id, Image image) {
        Image image1= imageRepository.findImageById(id);
        if (image1==null){
            throw new ApiException("wrong id");
        }
      image1.setUrl(image.getUrl());
        image1.setId(image.getId());
        imageRepository.save(image1);
    }
    public void deleteImage(Integer id){
        Image image = imageRepository.findImageById(id);
        if (image==null){
            throw new ApiException("wrong id");
        }

        imageRepository.delete(image);
    }

}
