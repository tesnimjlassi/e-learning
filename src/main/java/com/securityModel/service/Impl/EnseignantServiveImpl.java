package com.securityModel.service.Impl;


import com.securityModel.models.Enseignants;
import com.securityModel.repository.EnseignantRepository;
import com.securityModel.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignantServiveImpl implements EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public Enseignants createEnseignant(Enseignants enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public List<Enseignants> allEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignants enseignantById(Long id) {
        return enseignantRepository.findById(id).orElseThrow(() -> new RuntimeException("enseignant not found "));

    }

    @Override
    public Enseignants updateEnseignant(Long id, Enseignants enseignant) {
        Enseignants es=enseignantRepository.findById(id).orElseThrow(null);
        if (es != null){
            enseignant.setId(id);
            return enseignantRepository.save(enseignant);
        }else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);

    }
}
