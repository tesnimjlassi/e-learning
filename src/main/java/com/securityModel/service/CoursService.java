package com.securityModel.service;

import com.securityModel.models.Cours;

import java.util.List;

public interface CoursService {
    Cours createCours(Cours cours);
    List<Cours>allCourses();
    Cours coursById(Long id);
    Cours updateCours(Long id,Cours cours);
    void deleteCours(Long id);
}
