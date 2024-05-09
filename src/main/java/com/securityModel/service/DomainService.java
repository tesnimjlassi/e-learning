package com.securityModel.service;

import com.securityModel.models.Domain;

import java.util.List;

public interface DomainService {
    Domain createDomain(Domain domain);
    List<Domain> allDomains();
    Domain domainById(Long id);
    Domain updateDomain(Long id,Domain domain);
    void  deleteDomain(Long id);
}
