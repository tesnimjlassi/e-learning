package com.securityModel.service.Impl;


import com.securityModel.models.Cours;
import com.securityModel.repository.CoursRepository;
import com.securityModel.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursServiceImpl implements CoursService {
    @Autowired
     private CoursRepository coursRepository;
    @Override
    public Cours createCours(Cours cours){ return coursRepository.save(cours);}
    @Override
    public List<Cours> allCourses(){ return coursRepository.findAll();}
    @Override
    public Cours coursById(Long id){ return coursRepository.findById(id).orElseThrow(null);}
    @Override
    public Cours updateCours(Long id,Cours cours){
        Cours ad=coursRepository.findById(id).orElseThrow(null);
        if(ad!=null){
            cours.setId(id);
            return coursRepository.save(cours);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteCours(Long id){
        coursRepository.deleteById(id);
    }

}
