package com.securityModel.repository;

import com.securityModel.models.Enseignants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignants,Long> {
}
