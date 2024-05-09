package com.securityModel.repository;

import com.securityModel.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositopry extends JpaRepository<Category,Long> {
}
