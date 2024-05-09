package com.securityModel.service;

import com.securityModel.models.Formation;

import java.util.List;

public interface FormationService {
    Formation createFormation(Formation formation);
    List<Formation> allFormations();
    Formation formationById(Long id);
    Formation updateFormation(Long id,Formation formation);
    void deleteFormation(Long id);
}
