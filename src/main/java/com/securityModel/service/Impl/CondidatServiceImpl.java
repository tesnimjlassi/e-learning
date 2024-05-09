package com.securityModel.service.Impl;

import com.securityModel.models.Condidat;
import com.securityModel.repository.CondidatRepository;
import com.securityModel.service.CondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondidatServiceImpl  implements CondidatService {
    @Autowired
    CondidatRepository condidatRepository;
    @Override
    public Condidat createCondidat(Condidat condidat){ return condidatRepository.save(condidat);}
    @Override
    public List<Condidat> allCondidats(){ return condidatRepository.findAll();}
    @Override
    public Condidat condidatById(Long id){ return condidatRepository.findById(id).orElseThrow(null);}
    @Override
    public Condidat
    updatecondidat(Long id,Condidat condidat){
        Condidat cat=condidatRepository.findById(id).orElseThrow(null);
        if (cat!=null){
            condidat.setId(id);
            return condidatRepository.save(condidat);
        }else {
            throw new RuntimeException("Error!");
        }

    }
    @Override
    public void deletecondidat(Long id){
        condidatRepository.deleteById(id);
    }
}
