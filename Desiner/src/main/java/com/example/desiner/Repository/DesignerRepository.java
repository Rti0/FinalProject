package com.example.desiner.Repository;

import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignerRepository extends JpaRepository<Designer,Integer> {
    Designer findDesignerById(Integer id);

    @Query("select d from Designer d where d.myUser.id = ?1")
    Designer findDesignerByMyUser(Integer id);

    Designer findDesignerByName(String name);

    Designer findDesignerByEmail(String email);
}
