package com.securityModel.service.Impl;

import com.securityModel.models.Formation;
import com.securityModel.repository.FormationRepository;

import com.securityModel.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FormationServiceImpl implements FormationService {
    @Autowired
    private FormationRepository formationRepository;

    @Override
    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> allFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation formationById(Long id) {
        return formationRepository.findById(id).orElseThrow(() -> new RuntimeException("formation not found "));

    }

    @Override
    public Formation updateFormation(Long id, Formation formation) {
        Formation fm=formationRepository.findById(id).orElseThrow(null);
        if (fm != null){
            formation.setId(id);
            return formationRepository.save(formation);
        }else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);

    }
}
