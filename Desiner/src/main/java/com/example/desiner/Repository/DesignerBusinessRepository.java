package com.example.desiner.Repository;


import com.example.desiner.Model.Designer;
import com.example.desiner.Model.DesignerBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignerBusinessRepository extends JpaRepository<DesignerBusiness,Integer> {
DesignerBusiness findDesignerBusinessById(Integer id);

    List<DesignerBusiness> findDbByDesignerId(Designer designer);
    List<DesignerBusiness> findDesignerBusinessesByDesigner(Designer d);
}
