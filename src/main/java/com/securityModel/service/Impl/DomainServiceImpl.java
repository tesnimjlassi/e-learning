package com.securityModel.service.Impl;


import com.securityModel.models.Domain;
import com.securityModel.repository.DomainRepository;
import com.securityModel.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceImpl  implements DomainService {
    @Autowired
    private DomainRepository domainRepository;

    @Override
    public Domain createDomain(Domain domain) {
        return domainRepository.save(domain);
    }

    @Override
    public List<Domain> allDomains() {
        return domainRepository.findAll();
    }

    @Override
    public Domain domainById(Long id) {
        return domainRepository.findById(id).orElseThrow(() -> new RuntimeException("domain not found "));

    }

    @Override
    public Domain updateDomain(Long id, Domain domain) {
        Domain dm=domainRepository.findById(id).orElseThrow(null);
        if (dm != null){
            domain.setId(id);
            return domainRepository.save(domain);
        }else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public void deleteDomain(Long id) {
        domainRepository.deleteById(id);

    }
}
