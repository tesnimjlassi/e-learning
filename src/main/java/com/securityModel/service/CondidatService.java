package com.securityModel.service;

import com.securityModel.models.Condidat;

import java.util.List;

public interface CondidatService {
    Condidat createCondidat(Condidat condidat);
    List<Condidat> allCondidats();
    Condidat condidatById(Long id);
    Condidat updatecondidat(Long id,Condidat condidat);
    void deletecondidat(Long id);
}
