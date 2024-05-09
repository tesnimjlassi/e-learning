package com.securityModel.service;


import com.securityModel.models.Enseignants;

import java.util.List;

public interface EnseignantService {
    Enseignants createEnseignant(Enseignants enseignants);
    List<Enseignants>allEnseignants();
    Enseignants enseignantById(Long id);
    Enseignants updateEnseignant(Long id, Enseignants enseignants);
    void deleteEnseignant(Long id);
}
