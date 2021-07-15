package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao extends JpaRepository<Image,Integer> {
    List<Image> findImageBy();
    Image getByImageId(int id);

    List<Image> getByCandidatesId(int candidates_id);

    //Sistem personali için
    List<Image> getByCandidatesIdAndStatusTrue(int id);
    List<Image> getByCandidatesIdAndStatusFalse(int id);

}
