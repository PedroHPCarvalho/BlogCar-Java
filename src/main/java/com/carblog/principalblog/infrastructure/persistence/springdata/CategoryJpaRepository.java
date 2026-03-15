package com.carblog.principalblog.infrastructure.persistence.springdata;

import com.carblog.principalblog.infrastructure.persistence.entity.CategoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//
//**Por que o `findByNameCategory` funciona sem implementação?**
//
//O Spring Data lê o nome do metodo e gera o SQL automaticamente:
//        ```
//findBy        → WHERE
//NameCategory  → name_category = ?

public interface CategoryJpaRepository extends JpaRepository<CategoryJpa, UUID> {
    Optional<CategoryJpa> findByNameCategory(String nameCategory);
}
