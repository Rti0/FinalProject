package com.example.desiner.Repository;

import com.example.desiner.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {

    Image findImageById(Integer id);

}
